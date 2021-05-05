package com.greedy.section02.locale.javaconfig;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.locale.javaconfig.config.ContextConfiguration;


public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		//에러메시지를 꺼내와 출력
		//1. 꺼내올 메시지의 키값
		//2. 값을 바인딩하기 위해 사용한 {} 플레이스 홀더 없으면 null
		//3. locale 정보를 전달
		//locale에 따라 전달받는 값이 달라진다.
		String error404Message = context.getMessage("error.404", null, Locale.US);
		//플레이스홀더에 전달할 값을 object로 전달
		//여러개 일경우 object 배열로 전달
		String error500Message = context.getMessage("error.500", new Object[] {"sangejin", new Date()}, Locale.US);
		System.out.println("The I18N message for error.404 : " + error404Message);
		System.out.println("The I18N message for error.500 : " + error500Message);
		
		/*
		 * I18N 소프트웨어 국제화
		 * i 부터 n 까지 알파벳 숫자 
		 * 1. 언어, 지역별 번역 resourceMessageBundle
		 * 2. OS/플랫폼 인코딩
		 * 3. 문자열 치환 방법 : 서버쪽, 클라이언트 쪽 치환 중 서버쪽에서 하는 것이 더 좋다.(경우에 따라 다르긴 함)
		 * 4. 국제화 UI (문자열 크기 변화, 폰트, 아이콘)
		 * 5. 쓰기 방향 차이(아랍어 오른쪽 -> 왼쪽) 무튼
		 * 6. 숫자, 공백, 화폐, 날짜, 주소, 측정단위 등
		 * 7. 타임존, 섬머타임 등 시각
		 * 8. 문자열 정렬 방법
		 * */
	}
}
