package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.AchievementResult;

@Component
@Aspect
public class AfterReturningAttendingAdvice {
	
	//pointcut
	//기본적으로 pointcut은 필요
	//생략해도 여기지만 추가적인 속성을 넣을 때는 명시할 것
	//execution이 포인트컷 표현식 이용 //
	@AfterReturning(pointcut="execution(* com.greedy.section01.advice.annotation..*(..))", returning="result")
	public void afterReturningAttending(JoinPoint joinpoint, Object result) {
		//정상적으로 리턴되었을 때 실행되기 때문에 return 값 선언하면 받을 수 있다.
		//returning에 해당하는 속성과 받아올 매개변수의 이름이 같아야ㅕ한다.
		//returning의 속성은 리턴으로 받아올 변수이름설정
		//매개변수 result 메소드의 실행 리턴값 설정 로그 출력 or 리턴값 변경 조작
		
		//after advice보다 먼저 동작함
		System.out.println("=============== after returning attending =================");
		System.out.println("보ㅓ람찬! 하루일을! 끝마치고서~!~~ 두 다리 쭉펴면 고향의 안방~~!!");
		System.out.println("오늘의 이해도 : " + ((AchievementResult) result).getUnderstandingScore());
		System.out.println("오늘의 만족도 : " + ((AchievementResult) result).getSatisfactionScore());
		
		double employeementRate = ((AchievementResult) result).getEmployeementRate();
		double percent = employeementRate / 1000.0 * 100;
		//출력을 퍼센테이지로 보여줌 단순히 나타내는 것
		System.out.println("증가된 취업률 : " + percent + "%");
		
		//return 값에 대한 setter로 값 변경 return 값 변경
		((AchievementResult) result).setEmployeementRate(percent);
		
		System.out.println("======================================================");
	}
}



