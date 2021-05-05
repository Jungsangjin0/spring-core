package com.greedy.section02.locale.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {
	
	@Bean
	//messageSource 사전에 읽어서 메시지를 준비해주는 것
	//ReloadableResourceBundleMessageSource  :: 사용자가접속하는 session
	public ReloadableResourceBundleMessageSource messageSource() {
		
		//접속하는 세션의 로케일에 따라 자동 재로딩하는 용도의 MessageSource
		//properties를 미리 읽어들여서 저장하는것 messageSource
		//읽어들이는 messagSoure를 읽어들이고 다시 reload하는 것ReloadableResourceBundleMessageSource 
		ReloadableResourceBundleMessageSource messageSource =
				new ReloadableResourceBundleMessageSource();
		
		//다국어 메세지를 읽어올 properties 파일의 기본 파일 이름을 설정한다.
		//로케일이 존재하지 않는 경우 해당 파일을 읽어온다.
		//다국어 메세지를 읽어올 파일 설정
		//root이름이 message
		messageSource.setBasename("message");
		//몇 초동안 사용할 것인지
		messageSource.setCacheSeconds(10);
		//기본 개발툴 utf-8
		//읽어올 message utf-8이라는 것을 전달
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
}
