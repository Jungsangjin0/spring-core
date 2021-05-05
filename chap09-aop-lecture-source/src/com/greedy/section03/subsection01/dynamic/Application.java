package com.greedy.section03.subsection01.dynamic;

import java.lang.reflect.Proxy;

public class Application {

	public static void main(String[] args) {
		/*
		 * 프록시란?
		 * 실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.
		 * 디자인 패턴의 프록시 패턴과는 비슷하면서 조금 다른 개념이긴 한다.
		 * */
		//대리자 확장 추가 실제 객체
		
		Student student = new GreedyStudent();
		Handler handler = new Handler(student);
		
		//프록시 생성 arg0 -> class loading하는 가상 기계 
		//arg1 -> proxy를 만들 클래스에 대한 메타정보 :: interface만 가능 interface없이 프록시 생성불가
		//handler 필요 수행할 클래스 프록시를 만들 때 사용
		Student proxy = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[] {Student.class}, handler); 
		
		//student만 사용하면 study라는 메소드만 동작
		// 대신할 proxy 생성
		// 대신해서 메소드를 받아 처리 실행할 내용은 handler에 작성
		//실제 호출할 대상 오브젝트를 인자로 넘겨서 핸들러쪽에서 가진 상태에서
		//대상 인스턴스를 호출하기 위해 정보가 필요함
		//프록시가 내부적으로 가로채서 메소드를 호출할 떄 앞뒤로 추가한다.
		proxy.study(16);
		
		//프록시 생성은 크게 두 가지 방식이 제공된다.
		//1. JDK Dynamic Proxy 방식
		//2. CGLib 방식
		
		//aspectj에서 사용하는 프록시 생성은 1번 방식이다.
		//이 방식은 리플렉션을 이용해서 proxy 클래스를 동적으로 생성해주는 방식인데, 타겟의 인터페이스를 기준으로 proxy를 생성해준다.
		//타겟의 위임 코드를 InvocationHandler를 이용하여 작성하게 된다.
		//하지만 사용자가 타겟에 대한 정보를 잘못 주입하는 경우가 발생할 수 있기 때문ㅇ
		//내부적으로는 주입된 타겟에 대한 검증 코드를 거친 후 invoker가 동작하게 된다
		
//		  2번 방식은 동적으로 proxy를 생성하지만 바이트코드를 조작하여 프록시를 생성해주는 방식이다.
//		  인터페이스 뿐 아니라 타겟의 클래스가 인터페이스를 구현하지 않아도 프록시를 생성해준다.
//		  두 방식의 차이는 성능 차이인데 invoke 시 성능 차이가 나게 된다.
//		  CGLib (Code Generator Library)의 경우 처음 메소드가 호출된 당시 동적으로 타겟 클래스의 바이트코드를 조작하게 되고,
//		  그 이후 호출 시 부터는 변경된 코드를 재사용한다.
//		따라서 매번 검증 코드를 거치는 1번 방식보다는 성능면에서 빠르게 된다.
//		  또한 리플렉션에 의한 것이 아닌 바이트코드를 조작하는 방식이기 때문에 성능면에서는 더 우수한 방식이다.
//		 
//		 하지만 CGLib방식은 단점이 있었고, 스프링에서 기본적으로 제공되는 방식은 아니었기에 별도로 의존성을 추가하여 개발해야 했고,
//		  파라미터가 없는 default 생성자가 반드시 필요했으며, 생성된 프록시의 메소드를 호출하면 타겟의 생성자가 2번 호출되는 문제점들이 있었다.
//		  
//		 스프링 4.3, 스프링부트 1.3 부터 CGLib의 문제가 된 부분이 개선되어 기본 core패키지에 포함되게 되었고,
//		  스프링에서 기본적으로 사용하는 프록시 방식이 CGLib 방식이 되었다.

		
	}
}
