package com.xs.chain;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;



import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;


public class ContractUtils {
	private static Web3j web3j= Web3j.build(new HttpService("Http://192.168.1.104:7545"));
	private static String contractAddr="0x253E38a53Be5B531101e53A125bA28cebad79596";

	public static String registerAccount(String password) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException, IOException{
	
		return WalletUtils.generateNewWalletFile(password, new File("E:\\wallet"));
	}
	public static MetaCoin_sol_MetaCoin loadMetaCoin(Credentials credentials)
	{
		return	MetaCoin_sol_MetaCoin.load(contractAddr, web3j,credentials,new ContractPro());
	}
	
}
