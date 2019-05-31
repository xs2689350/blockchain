package com.xs.chain;

import java.math.BigInteger;

import org.web3j.tx.gas.ContractGasProvider;

class ContractPro implements ContractGasProvider{

	@Override
	public BigInteger getGasLimit() {
		// TODO Auto-generated method stub
		return BigInteger.valueOf(6_721_975);
	}

	@Override
	public BigInteger getGasLimit(String arg0) {
		// TODO Auto-generated method stub
		return BigInteger.valueOf(6_721_975);
	}

	@Override
	public BigInteger getGasPrice() {
		// TODO Auto-generated method stub
		return BigInteger.valueOf(20_000_000_000L);
	}

	@Override
	public BigInteger getGasPrice(String arg0) {
		// TODO Auto-generated method stub
		return BigInteger.valueOf(20_000_000_000L);
	}
	
}