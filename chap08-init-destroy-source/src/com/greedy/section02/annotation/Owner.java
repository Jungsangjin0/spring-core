package com.greedy.section02.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Owner {
	
	@PostConstruct
	public void openShop() {
		System.out.println("사장님 가게 문을 오픈하셨습니다. 이제 쇼핑할 수 있습니다.");
	}
	@PreDestroy
	public void closeShop() {
		System.out.println("사장님이 가게 문을 닫으셨습니다. 이제 쇼핑 불가");
	}
}
