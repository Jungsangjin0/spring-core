package com.greedy.section01.advice.annotation;


public interface Student {

	//열정을 받아 성취도 반환
	AchievementResult study(Passion passion) throws Exception;
	
	
}
