package com.lm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.dao.UserMapper;
import com.lm.model.User;
import com.lm.service.UserService;
import com.lm.utils.Page;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}
	
	@Override
	public Map<String, Object> getUserList(int pageon) {
	    // TODO Auto-generated method stub
	    Map<String,Object> map=new HashMap<String, Object>();
	    Page page=new Page(pageon);
	    page.setRowcountAndCompute(userMapper.selectPageListCount());
	    map.put("page", page);
	    map.put("list", userMapper.selectPageList(map));
	    return map;
	  }

}
