package com.demoshopping.DTO;

import com.demoshopping.entity.Product;

public class CartDTO {
	private Product product;
	private int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return Double.parseDouble(product.getPrice()) *quantity;
	}
	@Override
	public String toString() {
		return "CartDTO [product=" + product + ", quantity=" + quantity + ", totalPrice=" + getTotalPrice() + "]";
	}
	
}
