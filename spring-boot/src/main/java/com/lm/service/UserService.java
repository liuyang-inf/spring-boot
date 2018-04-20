package com.lm.service;

import java.util.List;
import java.util.Map;

import com.lm.model.User;

public interface UserService {

	List<User> findAll();

	Map<String, Object> getUserList(int pageon);

}
