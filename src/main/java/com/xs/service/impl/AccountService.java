package com.xs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xs.po.Account;
import com.xs.po.Student;


@Service
public interface AccountService 
{
	public abstract Account login(String sno, String pwd);
	public abstract boolean insertAccount(Account ac);
	public abstract Account getAccountByID(Integer id);
	
/*	
	public abstract List<Object> getAllStudent();
	public abstract List<Object> getStudent(String sno);
	public abstract boolean updateStudent(Student stu) ;
	
	public abstract  List<Object> showStudent(Student stu);
	public abstract boolean deleteStudent(Student stu);
	public abstract List<Object>  findStuName(String sname);
	public abstract String getMaxXH();*/
}
