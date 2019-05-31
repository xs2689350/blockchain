package com.xs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xs.mapper.ItemServiceMapper;
import com.xs.po.Item;
import com.xs.po.PageInfo;


@Service
public class ItemServiceImpl implements ItemService {

	@Resource
	private ItemServiceMapper  itemServiceMapper;

	@Override
	public List<Object> getUserItems(Integer userID) {
		// TODO Auto-generated method stub
		return itemServiceMapper.getUserItems(userID);
	}

	@Override
	public List<Object> getAllItems() {
		// TODO Auto-generated method stub
		return itemServiceMapper.getAllItems();
	}

	@Override
	public boolean insertItem(Item item) {
		// TODO Auto-generated method stub
		return itemServiceMapper.insertItem(item)>0;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return itemServiceMapper.getTotal();
	}

	@Override
	public PageInfo getItemPage(PageInfo pageInfo) {
		// TODO Auto-generated method stub
		Integer start = 0;
		if (pageInfo.getTotal() == null)
			pageInfo.setTotal(itemServiceMapper.getTotal());
		else
			start = (pageInfo.getPage() - 1) * pageInfo.getCount();
		
		List<Object> datas = itemServiceMapper.getItemPage(start, pageInfo.getCount());
		pageInfo.setRows(datas);

		return pageInfo;
	}

	

}
