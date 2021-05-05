package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application4 {

	public static void main(String[] args) {
		ApplicationContext context =
														//base package 설정할수 있도록 pakage 정보 전달
				new AnnotationConfigApplicationContext("com.greedy.section01.javaconfig", "com.greedy.section01.javaconfig.config");
		
		//베이스패키지를 문자열로 인자로 전달하면 basePakage로 설정한다
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
