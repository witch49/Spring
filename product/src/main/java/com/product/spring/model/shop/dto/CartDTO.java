package com.product.spring.model.shop.dto;

public class CartDTO {
	private int cart_id;
	private int product_id;
	private String product_name;
	private int amount;
	private int product_price;
	private int money;

	public CartDTO() {

	}

	public CartDTO(int cart_id, int product_id, String product_name, int amount, int product_price, int money) {
		this.cart_id = cart_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.amount = amount;
		this.product_price = product_price;
		this.money = money;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", amount=" + amount + ", product_price=" + product_price + ", money=" + money + "]";
	}

}
