package com.greedy.section03.xmlconfig;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<Product> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	
	public void addItem(Product item) {
		items.add(item);
	}
	
	public List<Product> getitem() {
		return items;
	}
}
