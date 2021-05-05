package com.greedy.section03.subsection02.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;

public class Handler implements InvocationHandler{

	private final GreedyStudent student;
	
	public Handler(GreedyStudent student) {
		this.student = student;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//프록시를 생성하면 호출되는 메소드
		//proxy -> 타겟 오브젝트
		//method -> 호출되는 메소드 정보
		//args -> 전달 인자
		
		//study 메소드 이전에 수행할 내용
		
		//ㅌ타겟오브젝트 실행전 proxy는 invoke라는 메소드 실행
		//그때 타겟오브젝트 실행전 아래 실행
		System.out.println("================== 공부가 너무 하고싶어요.==================");
		System.out.println("호출 대상 메소드 : " + method);
		for(Object arg : args) {
			System.out.println("전달된 잊나 : " + arg);
		}
		//타겟오브젝트 메소드 실행
		//student 탇겟오브젝트 대상 객체
		//args 전달받은 인자 넘기기
		//인자를 이용해 객체에 있는 method 호출
		method.invoke(student, args);
		
		System.out.println("================== 공부를 마치고 수면학습을 시작합니다.====================");
		
		return proxy;
	}
	
	
	
}
