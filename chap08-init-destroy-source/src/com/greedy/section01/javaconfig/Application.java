package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
//		Owner owner = context.getBean("owner", Owner.class);
//		owner.openShop();
		
		Product carpBread = context.getBean("carpBread", Bread.class);
		Product milk = context.getBean("milk", Beverage.class);
		Product water = context.getBean("water", Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
		cart1.addItem(carpBread);
		cart1.addItem(milk);
		
		ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
		cart2.addItem(water);
		
		System.out.println("cart1에 담긴 내용 : " + cart1.getitem() );
		System.out.println("cart1에 담긴 내용 : " + cart2.getitem() );
		
		
//		owner.closeShop();
		
		((AnnotationConfigApplicationContext)context).close();
		
				
	}
	
}
