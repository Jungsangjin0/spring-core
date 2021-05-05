package com.greedy.section01.advice.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new GenericXmlApplicationContext("com/greedy/section01/advice/xmlconfig/config/spring-context.xml");
		
		
		Student normalStudent = context.getBean("normalStudent", Student.class);
		Student greedyStudent = context.getBean("greedyStudent", Student.class);
		
		System.out.println("==========ㅁㅁNormalStudent===============");
		//대부분의 exception은 스프링컨테이너가 처리해줌  또는 try catch 사용
		AchievementResult normalResult = normalStudent.study(new Passion(10));
		System.out.println("noralStudent Reuslt : " + normalResult);
		
		System.out.println("============ greedyStudent======================");
		AchievementResult greedyResult = greedyStudent.study(new Passion(10));
		System.out.println("greedyStudent Result : "+ greedyResult);
				
	}

}
