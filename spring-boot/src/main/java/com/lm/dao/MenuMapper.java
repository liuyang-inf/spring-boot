package com.lm.dao;

import java.util.List;

import com.lm.model.Menu;

public interface MenuMapper {

	List<Menu> findAllRecursion();

}
