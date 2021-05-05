package com.greedy.section03.xmlconfig;

import org.springframework.stereotype.Component;

public class Owner {
	
	public void openShop() {
		System.out.println("사장님 가게 문을 오픈하셨습니다. 이제 쇼핑할 수 있습니다.");
	}
	public void closeShop() {
		System.out.println("사장님이 가게 문을 닫으셨습니다. 이제 쇼핑 불가");
	}
}
