package com.xs.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xs.po.PageInfo;
import com.xs.po.Transaction;

@Service
public interface TransactionService {
	public abstract List<Object> userInfo(String fromaddr);
	public abstract boolean insertTransaction(Transaction tsc);
	public abstract List<Object> getAllTransaction();
	public abstract PageInfo getTransactionPage(PageInfo pageInfo);
}
