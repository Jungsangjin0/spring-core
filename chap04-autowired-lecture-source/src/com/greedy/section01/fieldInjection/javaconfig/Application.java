package com.greedy.section01.fieldInjection.javaconfig;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * 	@Autowired를 이용한 의존성 주입
		 * 스프링 3.1 이후 버전부터 어노테이션을 이용한 bean 생성과 의존성 주입을 위한 어노테이션을 제공한다.
		 * 어노테이션을 이용하면 생성자주입과 setter주입 외에 필드 주입을 추가적으로 ㅅ사용할 수 있다.
		 * */
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.greedy.section01.fieldInjection.javaconfig");
		
		BookService bookService = context.getBean("bookService", BookService.class);
		
		System.out.println(bookService);
		
		List<BookDTO> bookList = bookService.selectAllBooks();
		for(BookDTO book : bookList) {
			System.out.println(book);
		}
	}
}
