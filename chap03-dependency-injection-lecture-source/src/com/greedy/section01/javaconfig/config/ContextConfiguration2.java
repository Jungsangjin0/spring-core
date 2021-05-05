package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greedy.section01.javaconfig.Account;
import com.greedy.section01.javaconfig.MemberDTO;
import com.greedy.section01.javaconfig.MemberDTO;
import com.greedy.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration2 {

	@Bean
	public Account accountGenerator() {
		
		return new PersonalAccount(20, "110-234-567890", "1234");
	}
	
	@Bean
	public MemberDTO memberGenerator() {
		
		MemberDTO member = new MemberDTO();
		Account account = accountGenerator();
		
		member.setSequence(1);
		member.setName("홍길동");
		member.setPhone("010-1234-5678");
		member.setEmail("hong123@gmail.com");
		member.setPersonalAccount(account);
		
		return member;
	}
}
