package com.xs.chain;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.web3j.protocol.core.methods.response.TransactionReceipt;


import com.xs.service.impl.TransactionServiceImpl;

public class Service {
	//private MetaCoin_sol_MetaCoin metaCoin;
	
	public static boolean transfer(MetaCoin_sol_MetaCoin metaCoin,String _to,BigInteger _value,BigInteger itemid)
	{
		try {
			TransactionReceipt tr=metaCoin.transfer(_to,itemid ,_value).send();
			if(tr!=null) return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static BigInteger balance(MetaCoin_sol_MetaCoin metaCoin,String _owner)
	{
		try {
			return metaCoin.balanceOf(_owner).send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
