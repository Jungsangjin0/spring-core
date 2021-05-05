package com.greedy.section02.constinjection.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRandomString {
	
	private RandomGenerator random;

	//스프링 4.3 이후부터는 생성자에 주입할 시 생성자가 한개 뿐이라면
	//해당 생성자에 @Autowried 어노테이션을 생략ㅎ도 자동으로 주입해준다
	//Autowired는 타입으로 일치하는 빈을 우선 탐색하기 때문에 이름이 달라도 상관없다.
	@Autowired
	public MakeRandomString(RandomGenerator random) {
		//생성자 주입의 장점
		//1. 필드 중비이 간단하긴 하짐나 단일책임의 원칙 관점에서 볼 때 필드는 수많은 빈들을 주입받을 수 있다는 단점이 있다.
		// 하지만 생성자 주입을 하게 되면 생성자의 매개변수가 많아지면서 좋ㅈ지 않은 느낌을 받고 맃팩토링의 지표로 삼을 수 있다.
		//2. 필드에 final 키워드 사용이 가능해진다.
		//3. 순환 참조 방지(필드 주입이나 세터 주입의 경우 메소드 실행 시점에 알 수 있지만, 생성자 주입은 실행 시점에서 ㅎ확인 가능하다)
		//4. DI 컨테이너와 결합도가 낮기 때문에 스프링 컨테이너 없는 독리적인 환ㄱ셩에서 테스트가 가능하다./
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
