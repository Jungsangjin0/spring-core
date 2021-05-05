package com.greedy.section01.advice.xmlconfig.aop;

import org.aspectj.lang.JoinPoint;

import com.greedy.section01.advice.xmlconfig.Passion;


public class BeforeAttendingAdvice {

	
	//접근 제한자 리턴타입 모든 // com.greedy.section01.advice.annotation 패키지 .. 하위믄것 . * 모든 메소드(..) 매개변수 상관없이
//	@Before("execution(* com.greedy.section01.advice.annotation..*(..))")
//	@Before("StudentPointcut.studyPointcut()")
	public void beforeAttending(JoinPoint joinPoint) {
		//joinpoint 대상 메소드에 대한 정보를 인자로 받는다 가장 첫번 째로 받아야한다.
		System.out.println("=========before attending===========");
		System.out.println("오늘도 입실카드를 찍는다.");
		//호출하는 대상 객체를 이용 // getClass 해당 클래스에 대한 정보를 받음 
		//joinpoint 오부ㅡ젝트가 아닌 대상 메소드
		//class com.greedy.section01.advice.annotation.NormalStudent //joinpoint의 타겟메소드의 클래스 정보
		System.out.println("수강생 타입() : " + joinPoint.getTarget().getClass());		//타겟 클래스 정보
		//AchievementResult com.greedy.section01.advice.anootation.Student.study(passion)
		//리턴타입            class 정보 + 메소드 정보 + 매개변수
		System.out.println("수강생의 행위 : " + joinPoint.getSignature()); 		//리턴타입을 포함한 시그니처
		//메소드 이름
		System.out.println("행위 용약 : " + joinPoint.getSignature().getName()); //메소드의 이름만 반환
		//매개변수
		System.out.println("수강생의 열정 : " + ((Passion)joinPoint.getArgs()[0]).getScore()); //대상 타켓메소드의 매개변수를 반환
		System.out.println("========================================");
	}
	
}
