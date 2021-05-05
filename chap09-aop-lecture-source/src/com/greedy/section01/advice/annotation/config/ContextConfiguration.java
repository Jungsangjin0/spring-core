package com.greedy.section01.advice.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy //aop 홝성화 선언 //컨테이너가 생성될 떄 타겟오브젝트에 대한 프록시 생성
//프록시 기반으로 어드바이스의 위빙 동작
//조인포인트에 끼워넣기 weaving -> aspectj weaver 라이브러리 다운
@EnableAspectJAutoProxy(proxyTargetClass = true) //동적 프록시 이용하겠다  true 명시
//true -> 동적프록시 cg라이브러리에서 지원하는 런타임당시 프록시 생성 방법 사용
//별도의 라이브러리 사용 후 등록해야하지만 기본설정으로 되어있기때문에 ㄱㅊ 관습적으로 붙이기
public class ContextConfiguration {

	//어스펙트제이 사용 컴파일 때 프록시를 생성해주는 기법 3.1까지 사용
	//3.2부터는 동적프록시를 사용하는 cg 라이브러리(런타임시 생성하는) 기본 스프링
	
	
}
