package com.xs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xs.po.Item;
import com.xs.po.PageInfo;


@Service
public interface ItemService {
	public abstract List<Object> getUserItems(Integer userID);
	public abstract List<Object> getAllItems();
	public abstract boolean insertItem(Item item);
	public abstract PageInfo getItemPage(PageInfo pageInfo);
	public abstract  int  getTotal();
}
