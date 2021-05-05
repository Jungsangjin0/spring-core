package com.greedy.section01.properties.javaconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.properties.javaconfig.Beverage;
import com.greedy.section01.properties.javaconfig.Bread;
import com.greedy.section01.properties.javaconfig.Product;
import com.greedy.section01.properties.javaconfig.ShoppingCart;

@Configuration
@PropertySource("product-info.properties")//별도로 작성한 properties 파일 사용
//클래스패스 하위에 있는 사용할 properties 경로
public class ContextConfiguration {

	//Value 라는 어노테이션을 먼저 읽어들인다.
	//공백은 사용하면 공백까지 읽어들이기때문에 key값을 찾지못한다.
	// 콜론(:)뒤에는 값이 불러오질 못할 경우 설정값
	@Value("${bread.carpbread.name:붕어빵}") //치환자 placeholder 
	private String carpBreadName;

	//spring el
	@Value("${bread.carpbread.price}")
	private int carpBreadPrice;

	@Value("${bread.milk.name}")
	private String milkname;
	@Value("${bread.milk.price:0}")
	private int milkPrice;
	@Value("${bread.milk.capacity:0}")
	private int milkCapacity;


	@Bean
	public Product carpBread() {
		return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
	}

	@Bean
	public Product milk() {
		return new Beverage(milkname, milkPrice, milkCapacity);
	}

	//value 매개변수에도 사용할 수 있다.
	@Bean
	public Product water(@Value("${beverage.water.name}")String waterName,
			@Value("${beverage.water.price:0}")int price,
			@Value("${beverage.water.capacity:0}") int waterCapacity) {

		return new Beverage(waterName, price, waterCapacity);
	}
	
	@Bean
	@Scope("prototype")
	public ShoppingCart cart() {
		
		return new ShoppingCart();
	}
}
