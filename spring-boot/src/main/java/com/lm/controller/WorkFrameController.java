package com.lm.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lm.model.Menu;
import com.lm.service.WorkFrameService;

@Controller
@RequestMapping("/work/frame")
public class WorkFrameController {
	
	@Autowired
	private WorkFrameService workFrameService;
	
    /**
     * thymeleaf
     * @param map
     * @return
     */
    @RequestMapping("/getMenu.do")
    public @ResponseBody JSONObject index(ModelMap map){
    	List<Menu> menuList = workFrameService.findAllRecursion();
    	JSONArray jsonArr = JSONArray.fromObject(menuList);
    	JSONObject json = new JSONObject();
    	json.put("data", jsonArr);
    	System.out.println(json);
    	return json;
    }
}
