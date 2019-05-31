package com.xs.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xs.po.Account;
import com.xs.po.Student;


@Service
public interface AccountServiceMapper 
{
	public abstract Account login(String user, String pwd);
	public abstract Integer insertAccount(Account ac);
	public abstract Account getAccountByID(Integer id);
	/*
	public abstract List<Object> getAllStudent();
	public abstract List<Object> getStudentPage(int start,int count);
	public abstract List<Object> getStudent(String sno);	
	public abstract Integer updateStudent(Student stu) ;

	public abstract List<Object> showStudent(Student stu);
	public abstract boolean deleteStudent(Student stu);
	public abstract List<Object>  findStuName(String sname);
	public abstract String getMaxXH();
	public abstract  int  getTotal();*/
}
