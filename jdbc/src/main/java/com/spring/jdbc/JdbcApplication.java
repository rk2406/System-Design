package com.spring.jdbc;

import com.spring.jdbc.dao.JdbcDaoImpl;
import com.spring.jdbc.models.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao= context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		dao.insertCircle(new Circle(247,"Gucci"));
		System.out.println(dao.getCircleUsingJdbcTemplate(247));
		System.out.println(dao.getCircleCount());
	}

}
