package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.annotation.GreedyStudent;

@Component
@Aspect
public class AroundAttendingAdvice {
	
	//포인트컷 메소드단위로 작성 메소드이름 해당 포인트컷의 이름
	@Pointcut("execution(* com.greedy.section01.advice.annotation..*(..))")
	private void studentAroundPointcut() {}
	//void로 작성하고 바디는 작성하지 않는다.
	//여러개 등록될 수 있기 때문에 메소드 이름 사용
	//메소드 이름을 advice에 ㅅ사용
	//동일한 클래스 내에서 사용할 경우 클래스명을 생략 하고 메소드명만 사용 가능 // 메소드 호출괄호 사용
	
	//사전에 실행할 내용은 before보다 먼저
	//around ->after return -> after 
	
//	@Around("execution(* com.greedy.section01.advice.annotation..*(..))")
	@Around("studentAroundPointcut()")
	public Object aroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
		//Object 형식 반환
		//joinpoint 하위 클래스 확장된 클래스
		
		System.out.println("===================== around attending before==================");
		System.out.println("오늘도 학원ㅇ[ㅔ 가서 열심히 공부하자 라고 일어난다.");
		System.out.println("===========================================================");
		
		//spring 유틸
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		//원본 조인포인트를 실행한다.
		Object result = joinPoint.proceed(); //원본 조인포인트를 실행 -> 실행 후 결과를 되 돌려줌
		
		System.out.println("================ around attending after =====================");
		//퇴실카드를 찍고난 후 에 멈추기
		if(joinPoint.getTarget() instanceof GreedyStudent) {
			System.out.println("수업이 끝나도 핛원이 닫을 때 까지는 끝난게 아닙니다. 자율적 스터디 ㄱ스룹과 함꼐 다시 공부!!");
		}
		
		System.out.println("열심히 공부를 했으니 퇴실카드를 찍는다.");
		
		stopWatch.stop();
		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		System.out.println("=====================================================");
		
		
		//원본 조인포인트를 호출한쪽으로 다시 advice 가 실행할 수 있도록
		return result;
	}
	
	
}
