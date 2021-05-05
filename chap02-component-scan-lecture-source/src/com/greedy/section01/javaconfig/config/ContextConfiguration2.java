package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Configuration
//베이스패키지 내부에 제외할 부분을 등록 excludeFilters
//basePackages : 중괄호 블럭으로 감싸서 사용
//@ComponentScan(basePackages = "com.greedy.section01.javaconfig",
//			 excludeFilters = {
//					 @ComponentScan.Filter(
							 	//1. 타입으로 지정
//							 type=FilterType.ASSIGNABLE_TYPE,
//							    //enum의 상수
//							 //원하는 타입만 스캔에서 제외
							 //구체적인 타입
//							 classes= {MemberDAO.class}
							 
							 //2. 어노테이션 종류로 설정
//							 type=FilterType.ANNOTATION,
//							 //원하는 어노테이션 생략
//							 classes= {org.springframework.stereotype.Component.class}
//							 )
					 
							 //3. 표현식으로 설정
							 //설정으로 해서 context2는 생성되지만 나머지는 따로 생성되지 않음
//							 type=FilterType.REGEX,
//							 pattern= {"com.greedy.section01.*"}
//					 	)
//			 })
public class ContextConfiguration2 {

}
