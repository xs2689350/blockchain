package com.xs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.xs.mapper.TransactionServiceMapper;
import com.xs.po.PageInfo;
import com.xs.po.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Resource
	private TransactionServiceMapper transactionServiceMapper;

	@Override
	public List<Object> userInfo(String fromaddr) {
		// TODO Auto-generated method stub
		return transactionServiceMapper.userInfo(fromaddr);
	}

	@Override
	public boolean insertTransaction(Transaction tsc) {
		// TODO Auto-generated method stub
		return transactionServiceMapper.insertTransaction(tsc) > 0;
	}

	@Override
	public List<Object> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionServiceMapper.getAllTransaction();
	}

	@Override
	public PageInfo getTransactionPage(PageInfo pageInfo) {
		// TODO Auto-generated method stub
		Integer start = 0;
		if (pageInfo.getTotal() == null)
			pageInfo.setTotal(transactionServiceMapper.getTotal());
		else
			start = (pageInfo.getPage() - 1) * pageInfo.getCount();
		
		List<Object> datas = transactionServiceMapper.getTransactionPage(start, pageInfo.getCount());
		pageInfo.setRows(datas);

		return pageInfo;

	}

}
