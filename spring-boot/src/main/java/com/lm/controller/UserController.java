package com.lm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lm.model.User;
import com.lm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * freemarker
	 * @param map
	 * @return
	 */
    @RequestMapping("/list")
    public String list(ModelMap map){
    	return "/userList";
    }
    
    @RequestMapping("userlist")
    public Object userlist(@RequestParam(value="pageon",defaultValue="1")int pageon,ModelAndView mv){
      mv.addAllObjects(userService.getUserList(pageon));
      return mv;
    }

    
    /**
     * thymeleaf
     * @param map
     * @return
     */
    @RequestMapping("/index.do")
    public String index(ModelMap map){
    	List<User> userList=userService.findAll();
    	map.addAttribute("userList", userList);
    	System.out.println(userList);
    	return "/index";
    }
}
