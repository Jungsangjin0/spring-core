package com.greedy.section04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		//java에서 사용하는 어노테이션
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.greedy.section04.resource");
	
		PokemonService pokemonService = context.getBean("pokemonService", PokemonService.class);
		pokemonService.pokemonAttack();
	}
}
