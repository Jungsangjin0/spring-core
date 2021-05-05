package com.greedy.section03.subsection02.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class Application {

	public static void main(String[] args) {
		
		GreedyStudent student = new GreedyStudent();
		Handler handler = new Handler(student);
		
		//프록시 생성하려는 타입, new Handler(new GreedyStudent()) ->/ handler
//		GreedyStudent proxy = (GreedyStudent) new Enhancer().create(GreedyStudent.class, handler);
		GreedyStudent proxy = (GreedyStudent) Enhancer.create(GreedyStudent.class, handler);
		
		proxy.study(16);
	}
}
