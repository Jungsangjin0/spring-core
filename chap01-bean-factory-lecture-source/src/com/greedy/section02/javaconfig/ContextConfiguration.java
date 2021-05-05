package com.greedy.section02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
	
	@Bean(name="member") //기본적으로 메소드 이름이 id가 된다.
	public MemberDTO getMember() {
		
		return new MemberDTO(1, "user01", "pass01", "홍길동");
	}
}
