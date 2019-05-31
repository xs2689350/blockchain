package com.xs.chain;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;

public class Register {
	public static String registerAccount(String password) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException, IOException
	{
		//Credentials credentials = WalletUtils.loadCredentials(password, new File(""));
		return WalletUtils.generateNewWalletFile(password, new File("E:\\wallet"));
	}
}
