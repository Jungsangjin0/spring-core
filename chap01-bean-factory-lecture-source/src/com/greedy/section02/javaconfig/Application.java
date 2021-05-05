package com.greedy.section02.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {

		//AnnotationConfigAppliatioNCOntext라는 어노테이션 설정 정보를 읽어서 컨테이너를 설정하는 구현체 이용.
		// 인자로 @Configuration 어노테이션이 달린 설정 클래스의 메타 정보를 전달하여 컨테이너를 생성한다.
			//설정정보를 담고있는 class의 정보를 인자로 전달
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
			//TargetSource jar
		
		//javaConfiguration으로 사용 시 아무런 설정을 하지않으면 빈의 id는 메소드의 이름이 된다.
//		MemberDTO member = context.getBean("getMember", MemberDTO.class);
		MemberDTO member = context.getBean("member", MemberDTO.class);
		System.out.println(member);
	}
}
