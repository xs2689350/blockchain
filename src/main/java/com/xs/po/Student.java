package com.xs.po;

public class Student 
{
	private String sno;
	private String sname;
	private Integer count;
	private String  loginTime;
	private String pwd;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", count=" + count + ", loginTime=" + loginTime + ", pwd="
				+ pwd + "]";
	}
   
}
