package com.lm.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonHelper {

	 public static List<Map<String, Object>> parseJSON2List(String jsonStr){  
	        JSONArray jsonArr = JSONArray.fromObject(jsonStr);  
	        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
	        Iterator<JSONObject> it = jsonArr.iterator();  
	        while(it.hasNext()){  
	            JSONObject json2 = it.next();  
	            list.add(parseJSON2Map(json2.toString()));  
	        }  
	        return list;  
	    }  
	      
	     
	    public static Map<String, Object> parseJSON2Map(String jsonStr){  
	        Map<String, Object> map = new HashMap<String, Object>();  
	        //最外层解析  
	        JSONObject json = JSONObject.fromObject(jsonStr);  
	        for(Object k : json.keySet()){  
	            Object v = json.get(k);   
	            //如果内层还是数组的话，继续解析  
	            if(v instanceof JSONArray){  
	                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
	                Iterator<JSONObject> it = ((JSONArray)v).iterator();  
	                while(it.hasNext()){  
	                    JSONObject json2 = it.next();  
	                    list.add(parseJSON2Map(json2.toString()));  
	                }  
	                map.put(k.toString(), list);  
	            } else {  
	                map.put(k.toString(), v);  
	            }  
	        }  
	        return map;  
	    }  
	    public static String convert(Object object) {
			ObjectMapper mapper = new ObjectMapper();
			StringWriter writer = new StringWriter();
			JsonGenerator gen;
			try {
				gen = new JsonFactory().createJsonGenerator(writer);
				mapper.writeValue(gen, object);
				gen.close();
				writer.close();
				String json = writer.toString();
				return json;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}
}
