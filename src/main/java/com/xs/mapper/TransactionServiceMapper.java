package com.xs.mapper;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xs.po.Transaction;


@Service
public interface TransactionServiceMapper {
	public abstract List<Object> userInfo(String fromaddr);
	public abstract Integer insertTransaction(Transaction tsc);
	public abstract List<Object> getAllTransaction();
	public abstract List<Object> getTransactionPage(int start,int end);
	public abstract  int  getTotal();
}
