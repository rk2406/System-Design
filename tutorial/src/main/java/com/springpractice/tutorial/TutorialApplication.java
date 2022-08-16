package com.springpractice.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TutorialApplication {

	public static void main(String[] args) {
//		Triangle triangle=new Triangle();
//		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("spring.xml"));
//		Triangle triangle= (Triangle) beanFactory.getBean("triangle");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape triangle= (Shape) context.getBean("triangle");
		triangle.draw();
		System.out.println();

		Shape circle=(Shape) context.getBean("circle");
		circle.draw();
	}

}
