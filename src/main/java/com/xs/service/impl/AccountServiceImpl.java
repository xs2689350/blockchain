package com.xs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xs.mapper.AccountServiceMapper;
import com.xs.po.Account;
import com.xs.po.Student;


@Service
public  class AccountServiceImpl implements AccountService{

	@Resource
	private AccountServiceMapper  accountServiceMapper;
	@Override
	public Account login(String user, String pwd) {
		// TODO Auto-generated method stub
		System.out.println(accountServiceMapper.getClass());
		return accountServiceMapper.login(user, pwd);
	}

	@Override
	public boolean insertAccount(Account ac) {
		// TODO Auto-generated method stub
		return accountServiceMapper.insertAccount(ac)>0;
	}

	@Override
	public Account getAccountByID(Integer id) {
		// TODO Auto-generated method stub
		return accountServiceMapper.getAccountByID(id);
	}
	
	/*@Override
	public List<Object> getAllStudent() {
		// TODO Auto-generated method stub
		
		return studentServiceMapper.getAllStudent();
	}

	@Override
	public List<Object> getStudent(String sno) {
		// TODO Auto-generated method stub
		return studentServiceMapper.getStudent(sno);
	}

	@Override
	public boolean updateStudent(Student stu) {
		// TODO Auto-generated method stub
		return accountServiceMapper.updateStudent(stu)>0;
	}

	

	@Override
	public List<Object> showStudent(Student stu) {
		// TODO Auto-generated method stub
		
		return accountServiceMapper.showStudent(stu);
	}

	@Override
	public boolean deleteStudent(Student stu) {
		// TODO Auto-generated method stub
		return  accountServiceMapper.deleteStudent(stu);
	}

	@Override
	public List<Object> findStuName(String sname) {
		// TODO Auto-generated method stub
		return accountServiceMapper.findStuName(sname);
	}
	@Override
	public String getMaxXH() {
		// TODO Auto-generated method stub
		return accountServiceMapper.getMaxXH();
	}
	*/
}
