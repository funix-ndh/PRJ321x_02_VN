package asm3.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public void add(Product product) {
		for (Product item : items) {
			if (item.getId() == product.getId()) {
				item.setNumber(item.getNumber() + 1);
				return;
			}
		}
		items.add(product);
	}
	public void remove(Product product) {
		items.remove(product);
	}
	public Double getAmount() {
		Double s = 0.0;
		for (Product item : items) {
			s += item.getPrice() * item.getNumber();
		}
		return Math.round(s * 100.0) / 100.0;
	}
	public List<Product> getItems() {
		return items;
	}
	public Integer count() {
		return items.size();
	}
}
