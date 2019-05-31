package com.xs.chain;

import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Web3j web3j = Web3j.build(new HttpService("Http://192.168.43.104:7545"));
		BigInteger re = null;
		TransactionReceipt rcp;
		Credentials credentials = Credentials.create("3aa4676f9f34fecd9f8a82f9d583451adfb43044adc5ac1cf2ee06246d9fd472");	
		MetaCoin_sol_MetaCoin metaCoin = MetaCoin_sol_MetaCoin.load("0x8a3FB4176802964C837D5bEade8568c58D7d3815", web3j, credentials, new ContractPro());
		rcp = metaCoin.transfer("0x20B20c80394DeF6A9F111e701d99277AA2002Bc8", BigInteger.valueOf(1),BigInteger.valueOf(1)).send();
		re = metaCoin.balanceOf(credentials.getAddress()).send();
		System.out.println("the credentials balance :"+re);
		
		

		web3j.shutdown();
	}

}
