package com.xs.chain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.reactivestreams.Subscription;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.core.methods.response.EthBlock.Block;
import org.web3j.protocol.core.methods.response.EthSyncing.Result;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;

import io.reactivex.disposables.Disposable;

public class Demo {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\main\\resources\\blockchainconf.properties"));
	
		
		
		Web3j web3j = Web3j.build(new HttpService(properties.getProperty("blockchainIP")));
			
		BigInteger re = null;
		TransactionReceipt rcp;
		Credentials credentials = Credentials.create(properties.getProperty("adminKey"));	
		MetaCoin_sol_MetaCoin metaCoin = MetaCoin_sol_MetaCoin.load(properties.getProperty("metacoinAddr"), web3j, credentials, new ContractPro());
		Event MY_EVENT = new Event("Transfer", 
				Arrays.<TypeReference<?>>asList(
				new TypeReference<Address>(false) {},
				new TypeReference<Address>(false) {}, 
				new TypeReference<Uint256>(false) {},
				new TypeReference<Uint256>(true) {}
				));
		String MY_EVENT_HASH = EventEncoder.encode(MY_EVENT);
		EthFilter filter=new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST,properties.getProperty("metacoinAddr"));
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				web3j.ethLogFlowable(filter).subscribe(log -> {
					String eventHash = log.getTopics().get(0);
					if(eventHash.equals(MY_EVENT_HASH))
					{
						 System.out.println(log);
						Address arg1 = (Address) FunctionReturnDecoder.decodeIndexedValue(log.getTopics().get(1), new TypeReference<Address>() {});
						Address arg2 = (Address) FunctionReturnDecoder.decodeIndexedValue(log.getTopics().get(2), new TypeReference<Address>() {});
						Uint256 arg3 = (Uint256) FunctionReturnDecoder.decodeIndexedValue(log.getTopics().get(3), new TypeReference<Uint256>(true) {});
						Integer i=Integer.parseInt(new BigInteger(log.getData().substring(2),16).toString(10));		
				        System.out.println("getBlockNumber:"+log.getBlockNumber());
				        System.out.println("arg1:"+arg1+"\n"+
				        		"arg2:"+arg2+"\n"+
				        		"arg3:"+arg3.getValue()+"\n"+
				        		"i:"+i);
					}
				    		    
				});
			}
		}).start();
		
		
		
		
		
		
		
	/*	web3j.blockFlowable(false).subscribe(ethBlock -> {
				Block block = ethBlock.getBlock();
				System.out.println("blockFlowable subscribe************** :" + block.getNumber());
			});
		web3j.transactionFlowable().subscribe(tx ->{
			System.out.println("transactionFlowable subscribe************** :" + tx.getBlockNumber());
		});
		
		
		web3j.pendingTransactionFlowable().subscribe(tx -> {
			System.out.println("pendingTransactionFlowable subscribe************** :" + tx.getBlockNumber());
			
		});
		
		web3j.ethLogFlowable(filter).subscribe(log -> {
			String eventHash = log.getTopics().get(0);
			if(eventHash.equals(MY_EVENT_HASH))
			{
				Address arg1 = (Address) FunctionReturnDecoder.decodeIndexedValue(log.getTopics().get(1), new TypeReference<Address>() {});
				Address arg2 = (Address) FunctionReturnDecoder.decodeIndexedValue(log.getTopics().get(2), new TypeReference<Address>() {});
		        String arg3 = log.getData();
		        System.out.println("getBlockNumber:"+log.getBlockNumber());
		        System.out.println("arg1:"+arg1+"arg2:"+arg2+"arg3:"+arg3);
			}
		    		    
		});
		//Credentials credential2 = WalletUtils.loadCredentials("123", new File("e://wallet//123.json"));

		
		Credentials credentials2 = Credentials.create("1a3d54ce97b1b64cc95e9222f87cf510d3d10ab22d543db1a20b22a7eebe5aaf");		
		MetaCoin_sol_MetaCoin metaCoin2 = MetaCoin_sol_MetaCoin.load("0x253E38a53Be5B531101e53A125bA28cebad79596", web3j, credentials2, new contractPro());
		
		
		re = metaCoin.balanceOf(credentials.getAddress()).send();
		System.out.println("the init balance :"+re);
		rcp = metaCoin.transfer("0xbFc271e16Fb24F5F95f86f5bC64E90019769B1B8", BigInteger.valueOf(4)).send();
		re = metaCoin.balanceOf(credentials.getAddress()).send();
		System.out.println("the ****** balance :"+re);
		
		rcp = metaCoin2.transfer("0xD3250D182582CF45b84A41A5cA0a28a8c8538BF1", BigInteger.valueOf(1)).send();
		re = metaCoin2.balanceOf(credentials2.getAddress()).send();
		System.out.println("the ****** balance :"+re);
		
		
		
		rcp = metaCoin.transfer("0xbFc271e16Fb24F5F95f86f5bC64E90019769B1B8", BigInteger.valueOf(4)).send();
		re = metaCoin.balanceOf(credentials.getAddress()).send();
		System.out.println("the ****** balance :"+re);
		
		rcp = metaCoin2.transfer("0xD3250D182582CF45b84A41A5cA0a28a8c8538BF1", BigInteger.valueOf(1)).send();
		re = metaCoin2.balanceOf(credentials2.getAddress()).send();
		System.out.println("the ****** balance :"+re);
		
		re = metaCoin.balanceOf(credentials.getAddress()).send();
		System.out.println("the first account's balance :"+re);
		rcp = metaCoin.transfer(credential2.getAddress(), BigInteger.valueOf(1)).send();
		re = rcp.getBlockNumber();
		System.out.println("the receipt's number:"+re);
		
		
		re = metaCoin.balanceOf(credential2.getAddress()).send();
		System.out.println("the second account's balance :"+re);
		
		
		
		
		web3j.transactionFlowable().subscribe(tx ->{
			System.out.println("transactionFlowable subscribe************** :" + tx.getBlockNumber());
		});
		
		
		web3j.pendingTransactionFlowable().subscribe(tx -> {
			System.out.println("pendingTransactionFlowable subscribe************** :" + tx.getBlockNumber());
			
		});
		
		*/
		//web3j.shutdown();
		/*	private static LoadSmartContract loadSmartContract;
		private LoadSmartContract(){}
		private static LoadSmartContract getInstance(){
			if(loadSmartContract == null) {
				synchronized(LoadSmartContract.class){
					loadSmartContract =new LoadSmartContract();
				}
			}
			return loadSmartContract;
		}*/
	}
	
}

