package com.greedy.section03.collection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Squirtle implements pokemon{

	@Override
	public void attack() {
		System.out.println("나는야 꼬부기 물대포우~");
		
	}

	
}
