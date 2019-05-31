package com.xs.po;

public class Account {
	private Integer id;
	private String username;
	private String accountnum;
	private String password;
	private String  privatekeyfile;
	private String  keyword;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrivatekeyfile() {
		return privatekeyfile;
	}
	public void setPrivatekeyfile(String privatekeyfile) {
		this.privatekeyfile = privatekeyfile;
	}
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", accountnum=" + accountnum + ", password=" + password
				+ ", privatekeyfile=" + privatekeyfile + ", keyword=" + keyword + "]";
	}
	

}
