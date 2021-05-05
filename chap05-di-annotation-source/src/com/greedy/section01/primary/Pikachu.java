package com.greedy.section01.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//primary 어노테이션을 설정하면 autowired로 동일한 타입의 여러 빈을 찾게 되는 경우  자동연결을 우선시 할 타입으로 설정함
//동일한 타입 pokemon 클래스 중 한개만 primart ㅅ사용 가능
@Primary
public class Pikachu implements pokemon{

	@Override
	public void attack() {
		System.out.println("피카츄가 공격을 ㅎ ㅏㅂ니다!! 백만볼트 ~ ");
	}

}
