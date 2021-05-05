package com.greedy.section01.javaconfig;

public abstract class Product {

	//추상클래스 인터페이스 차이
	//추상클래스 완성된 메소드를 가질 수 있다.
	//상수 필드 이외에 일반적인 필드를 가질 수 있다.
	private String name;
	private int price;
	
	public Product() {}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " " + price;
	}
	
	
}
