package com.xs.controller;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.xs.chain.LoadSmartContractImpl;
import com.xs.chain.MetaCoin_sol_MetaCoin;

@Component
public class AfterServiceStarted implements ApplicationRunner {

	@Resource
	private  LoadSmartContractImpl loadSmartContractImpl;
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		// TODO Auto-generated method stub
		
	/*	MetaCoin_sol_MetaCoin meta=loadSmartContractImpl.loadMetaCoin();
		loadSmartContractImpl.listenEvent(meta).start();
		System.out.println("ethereum connected!");*/
	}

}
