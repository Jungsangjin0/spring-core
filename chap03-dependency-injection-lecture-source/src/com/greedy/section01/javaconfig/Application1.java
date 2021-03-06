package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

	public static void main(String[] args) {
		
		//1명 회원이 1개의 계좌를 갖고 있는 것
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration1.class);
		
		MemberDTO member = context.getBean(MemberDTO.class);
		
		System.out.println(member);
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().deposit(1000000));
		System.out.println(member.getPersonalAccount().getBalance());
		System.out.println(member.getPersonalAccount().withDraw(500000));
		System.out.println(member.getPersonalAccount().getBalance());
	}
	
}
