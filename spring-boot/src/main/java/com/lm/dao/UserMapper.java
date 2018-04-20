package com.lm.dao;

import java.util.List;
import java.util.Map;

import com.lm.model.User;

public interface UserMapper {

	List<User> findAll();

	int selectPageListCount();

	List<User> selectPageList(Map<String, Object> map);

}
