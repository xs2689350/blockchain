package com.xs.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xs.po.Item;



@Service
public interface ItemServiceMapper {
	public abstract List<Object> getUserItems(Integer userID);
	public abstract List<Object> getAllItems();
	public abstract Integer insertItem(Item item);
	public abstract List<Object> getItemPage(int start,int end);
	public abstract  int  getTotal();

}
