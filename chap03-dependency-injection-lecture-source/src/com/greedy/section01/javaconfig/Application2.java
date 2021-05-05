package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;
import com.greedy.section01.javaconfig.config.ContextConfiguration2;

public class Application2 {

	public static void main(String[] args) {
		//setter를 이용
		
		//1명 회원이 1개의 계좌를 갖고 있는 것
				ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration2.class);
				
				MemberDTO member = context.getBean(MemberDTO.class);
				
				System.out.println(member);
				System.out.println(member.getPersonalAccount().getBalance());
				System.out.println(member.getPersonalAccount().deposit(1000000));
				System.out.println(member.getPersonalAccount().getBalance());
				System.out.println(member.getPersonalAccount().withDraw(500000));
				System.out.println(member.getPersonalAccount().getBalance());
			
	}
}
