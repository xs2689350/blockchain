package com.xs.chain;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

@Service
public class LoadSmartContractImpl implements LoadSmartContact{
	private  Web3j web3j= Web3j.build(new HttpService("Http://192.168.43.104:7545"));
	private  MetaCoin_sol_MetaCoin metaCoin; 
	private  String contractAddr="0xe6136Fc15DbB2E67590ff6B6502d27B1b5Fa6dFE";
	private  Credentials admin = Credentials.create("e510c78ad4e81eb6520491579d9a5f44eedecd93e897cd543fbe9ff46125f21d");	

	@Resource
	private Listener listener;
	
	public  MetaCoin_sol_MetaCoin loadMetaCoin()
	{
		return	MetaCoin_sol_MetaCoin.load(contractAddr, web3j,admin,new ContractPro());
	}
	public  Thread listenEvent(Contract contract)
	{
		listener.setParameters(web3j, contract);
		return new Thread(listener);
	}
}
