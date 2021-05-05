package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context.xml");
		
		MemberDTO member = context.getBean(MemberDTO.class);
		Account acc = member.getPersonalAccount();
		
		System.out.println(member);
		System.out.println(acc);
		System.out.println(acc.getBalance());
		System.out.println(acc.deposit(1000000));
		System.out.println(acc.getBalance());
		System.out.println(acc.withDraw(50000));
		System.out.println(acc.getBalance());
	}
}
