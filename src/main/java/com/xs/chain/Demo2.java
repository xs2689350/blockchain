package com.xs.chain;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Properties;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Properties properties=new Properties();
		properties.load(new FileInputStream("src\\main\\resources\\blockchainconf.properties"));
	
		Web3j web3j = Web3j.build(new HttpService(properties.getProperty("blockchainIP")));
		BigInteger re = null;
		TransactionReceipt rcp;
		Credentials credentials = Credentials.create(properties.getProperty("adminKey"));	
		MetaCoin_sol_MetaCoin metaCoin = MetaCoin_sol_MetaCoin.load(properties.getProperty("metacoinAddr"), web3j, credentials, new ContractPro());
		Credentials credentials2 = Credentials.create(properties.getProperty("secondKey"));
		/*Credentials credentials2 = Credentials.create("1a3d54ce97b1b64cc95e9222f87cf510d3d10ab22d543db1a20b22a7eebe5aaf");		
		MetaCoin_sol_MetaCoin metaCoin2 = MetaCoin_sol_MetaCoin.load("0x8a3FB4176802964C837D5bEade8568c58D7d3815", web3j, credentials2, new ContractPro());
		*/
		rcp = metaCoin.transfer(properties.getProperty("secondAddr"),BigInteger.valueOf(10) ,BigInteger.valueOf(1)).send();
		re = metaCoin.balanceOf(credentials2.getAddress()).send();
		System.out.println("the credentials2 balance :"+re);
		
		
		

		web3j.shutdown();
	}

}
