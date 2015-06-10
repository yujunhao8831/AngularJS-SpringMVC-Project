package com.crm.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JacksonUtil {
	
	public static String writeValueAsString(Object message){
		try {
			
			return new ObjectMapper().writeValueAsString(message);
		} catch (JsonProcessingException e) {
			new RuntimeException("JSON转换失败!");
			return null;
		}
	}
}
