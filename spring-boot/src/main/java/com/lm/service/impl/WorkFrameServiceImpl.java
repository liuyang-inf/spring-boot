package com.lm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.dao.MenuMapper;
import com.lm.model.Menu;
import com.lm.service.WorkFrameService;

@Service
public class WorkFrameServiceImpl implements WorkFrameService{
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> findAllRecursion() {
		return menuMapper.findAllRecursion();
	}
	
}
