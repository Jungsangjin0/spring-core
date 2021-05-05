package com.greedy.section03.collection;

import org.springframework.stereotype.Component;

@Component
public class Pikachu implements pokemon{

	@Override
	public void attack() {
		System.out.println("피카츄가 공격을 ㅎ ㅏㅂ니다!! 백만볼트 ~ ");
	}

}
