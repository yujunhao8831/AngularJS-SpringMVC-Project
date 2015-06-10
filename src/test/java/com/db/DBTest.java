package com.db;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBTest {
	
private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-hibernate.xml");
	
	@Test
	public void testDB() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
	}
}
