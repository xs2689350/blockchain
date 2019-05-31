package com.xs.po;

public class Transaction {
	private String transactionhash;
	private String fromaddr;
	private String toaddr;
	private String musicid;
	private Integer price;
	public String getTransactionid() {
		return transactionhash;
	}
	public void setTransactionid(String transactionhash) {
		this.transactionhash = transactionhash;
	}
	public String getFromaddr() {
		return fromaddr;
	}
	public void setFromaddr(String fromaddr) {
		this.fromaddr = fromaddr;
	}
	public String getToaddr() {
		return toaddr;
	}
	public void setToaddr(String toaddr) {
		this.toaddr = toaddr;
	}
	public String getMsicid() {
		return musicid;
	}
	public void setMsicid(String msicid) {
		this.musicid = msicid;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Transaction [transactionhash=" + transactionhash + ", fromaddr=" + fromaddr + ", toaddr=" + toaddr
				+ ", msicid=" + musicid + ", price=" + price + "]";
	}
	

}
