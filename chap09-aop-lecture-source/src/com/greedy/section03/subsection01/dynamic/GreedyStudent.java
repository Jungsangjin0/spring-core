package com.greedy.section03.subsection01.dynamic;

import org.springframework.stereotype.Component;

public class GreedyStudent implements Student{

	@Override
	public void study(int hour) {
		
		System.out.println(hour + "시간 동안 열심히 공부합니다.");
	}

	

}
