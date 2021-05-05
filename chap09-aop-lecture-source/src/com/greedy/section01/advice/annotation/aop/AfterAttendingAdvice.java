package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAttendingAdvice {
	
	//무조건 동작 정상,오류 둘다
	@After("execution(* com.greedy.section01.advice.annotation..*(..))")
	public void afterAttending(JoinPoint joinPoint) {
		System.out.println("=====================after attending");
		System.out.println("내일도 학원에 가서 열심히 공부해야지! 라고 잠이 듭니다.");
		System.out.println("==================================");
	}
	
	
	
}	
