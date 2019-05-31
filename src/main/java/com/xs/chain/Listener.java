package com.xs.chain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;


import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.tx.Contract;

import org.springframework.stereotype.Service;

import com.xs.po.Transaction;
import com.xs.service.impl.TransactionServiceImpl;

@Service 
public class Listener implements Runnable{
	@Resource
	private TransactionServiceImpl transactionServiceImpl;
	
	private Web3j web3j;
	private Contract contract;
	
	private List<TypeReference<?>> listForTransfer= Arrays.<TypeReference<?>>asList(
			new TypeReference<Address>(true) {}, 
			new TypeReference<Address>(true) {}, 
			new TypeReference<Uint256>(false) {});
	public void setParameters(Web3j web3j,Contract contract) 
	{
		this.web3j=web3j; 
		this.contract=contract;
	}
	
	public void run() {
		if(contract==null) return ;
		Event MY_EVENT_TRANSFER = new Event("Transfer", listForTransfer);
		String TRANSFER_HASH = EventEncoder.encode(MY_EVENT_TRANSFER);
		EthFilter filter_MetaCoin = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST,contract.getContractAddress());
		web3j.ethLogFlowable(filter_MetaCoin).subscribe(log -> {
			String eventHash = log.getTopics().get(0);
			//过滤事件 
			if(eventHash.equals(TRANSFER_HASH))
			{
				Address arg1 = (Address) FunctionReturnDecoder.decodeIndexedValue(log.getTopics().get(1), new TypeReference<Address>() {});
				Address arg2 = (Address) FunctionReturnDecoder.decodeIndexedValue(log.getTopics().get(2), new TypeReference<Address>() {});
				Integer i=Integer.parseInt(new BigInteger(log.getData().substring(2),16).toString(10));
				Transaction tsc=new Transaction();
				tsc.setFromaddr(arg1.toString());
				tsc.setToaddr(arg2.toString());
				tsc.setPrice(i);
				tsc.setTransactionid(log.getTransactionHash());
				if(transactionServiceImpl==null) System.out.println(tsc);
				
				transactionServiceImpl.insertTransaction(tsc);
		       
			}
		    		    
		});
	}

}
