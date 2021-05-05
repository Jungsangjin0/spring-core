package com.greedy.section01.advice.xmlconfig.aop;

import org.aspectj.lang.JoinPoint;

public class AfterAttendingAdvice {
	
	public void afterAttending(JoinPoint joinPoint) {
		System.out.println("=====================after attending");
		System.out.println("내일도 학원에 가서 열심히 공부해야지! 라고 잠이 듭니다.");
		System.out.println("==================================");
	}
	
	
	
}	
