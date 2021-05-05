package com.greedy.section01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		// 한개의 인터페이스를 상속받은 여러 클래스를 모두 bean으로 등록하는 경우 해결 방법
		// 여러 타입의 bean이 존재한느 경우 자동연결 시 어떠한 빈을 주입할 지에 대한 여부가 확실하지 않은 상황 발생
		//@Autowired는 타입이 일치하는 bean을 자동 연결하기 때문이다.
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section01.primary");
		
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		pokemonService.pokemonAttack();
		
	}
}
