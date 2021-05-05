package com.greedy.section01.advice.annotation.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class StudentPointcut {

	//내부 여러개의 포인트 컷을 설정하기 위한 클래스
	@Pointcut("execution(* com.greedy.section01.advice.annotation..*(..))")
	public void studyPointcut() {}
	
}
