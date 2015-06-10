package com.test.jackson;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackson {
	
	
	@Test
	public void testName() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		TestJacksonBean bean = objectMapper.readValue("{\"name\":\"余峻豪\",\"age\":\"22\"}", TestJacksonBean.class);
		System.out.println(bean);
	}
	
	public static void main(String[] args) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		TestJacksonBean bean = objectMapper.readValue("{\"name\":\"余峻豪\",\"age\":\"22\"}", TestJacksonBean.class);
		
		System.out.println(bean);
		bean.setAge(22);
		bean.setName("222");
		String json = objectMapper.writeValueAsString(bean);
		System.out.println("json"+json);
		
//		TestJacksonBean [name=余峻豪, age=22]
//		json{"name":"222","age":22}
	}
}
