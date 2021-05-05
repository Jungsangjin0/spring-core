package com.greedy.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
	
	
	public static void main(String[] args) {
		
		//beanFactory 기능 살펴보기
		// beanfactory란
		//스프링 컨테이너의 최상위 컨테이너이며, ApplicationContext와 함께 스프링 컨테이너라고 한다.
		//Bean의 생성과 설정, 관리 등의 역할을 맡고 있다.
		//설정의 의도대로 만들어 적용
		
		
		//ApplicationContext의 하위 구현체임 GenericXmlApplicationContext는 xml 설정 메타 정보를 읽어와서
		// BeanFactory를 동작시킨다.
		//GenericXmlApplicationCOntext는 설정 메타 정보가 담긴 xml 파일의 경로를 클래스패스 하위 경로를 전부 기술해야
		//설정 파일을 읽어올 수 있다.(패키지 내에 존재해도 물리적으로는 폴더이기 때문에 하위 폴더는 \\ 혹은 / 로 부분해야 한다.)
		
		ApplicationContext context 
									= new GenericXmlApplicationContext("com/greedy/section01/xmlconfig/spring-context.xml");
										//xml은 java 파일이 아니기때문에 패키지 단위가 아니라 폴더구분을 사용함 \\ 또는 / 패키지구분인.은 사용 불가
		
		
		//컨테이너가 보관하고 있는 bean을 꺼내서 사용할 때는 getBean() 메소드를 이용한다.
		//getBean() 메소드는 타입, id를 이요해서 bean을 꺼내올 수 있는 기능을 오버로딩 해놓음
		
		//1. bean의 id를 이용해 bean을 가져오는 방법
//		MemberDTO member = (MemberDTO) context.getBean("member"); //bean의 id
//		System.out.println(member);
		
		//2. bean의 타입으로 bean을 가져오는 방법
//		MemberDTO member = context.getBean(MemberDTO.class);
//		System.out.println(member);
		
		//3. bean의 id와 클래스 메타 정보를 전달하여 가져오는 방법
		MemberDTO member = context.getBean("member", MemberDTO.class);
		System.out.println(member);
		
		
	}

}
