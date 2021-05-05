package com.greedy.section02.constinjection.xmlconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MakeRandomString {
	
	private RandomGenerator random;

	public MakeRandomString(RandomGenerator random) {
		this.random = random;
	}
	
	public String getRandomLenthString() {

		StringBuilder sb = new StringBuilder();

		int randomNumber =random.getRandomNumber();

		for(int i = random.getStartNum(); i <= randomNumber; i ++) {
			sb.append("*");
		}
		return sb.toString();
	}
}
