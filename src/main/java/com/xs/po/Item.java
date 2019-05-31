package com.xs.po;

public class Item {
	private Integer itemid;
	private String itemname;
	private Integer userid;
	private String path;
	private Integer price;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", userid=" + userid + ", path=" + path
				+ ", price=" + price + "]";
	}
	
	
}
