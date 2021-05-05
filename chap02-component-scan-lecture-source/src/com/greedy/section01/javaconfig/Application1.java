package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration1;

public class Application1 {

	public static void main(String[] args) {
		//컴포넌트스캔 기능을 이용한 bean 등록 설정
		//componentScan이란?
		//base-package로 설정된 경로 하위에 특정 어노테이션을 가지고 있는 클래스를 이용하여 bean으로 등록한다.
		//@Component 어노테이션이 작성된 클래스를 bean으로 인식하여 bean으로 만들게 되며, 특수 목저에 따라 세부 기능을 제공하는
		//@Controller, @Service, @Repository, @configueration등을 인식한다.
		
		//설정정보를 가지고 클래스정보를 넘김
		//config에 설정파일이 있기 때문에 자동적으로 basepackage로 등록하기 때문에 
		//바깥에 있는 bean들을 등록할 수없음 범위 밖에 있음
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration1.class);
		
		System.out.println(context);
		
		MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
		System.out.println(memberDAO.selectMember(1));
		System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03","pass03", "새로운멤버")));
		System.out.println(memberDAO.selectMember(3));
	}
}
