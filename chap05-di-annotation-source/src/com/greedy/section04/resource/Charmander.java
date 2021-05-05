package com.greedy.section04.resource;

import org.springframework.stereotype.Component;

@Component
public class Charmander implements pokemon{

	@Override
	public void attack() {
		System.out.println("파이리의 공격 파이어볼");
	}

	
}
