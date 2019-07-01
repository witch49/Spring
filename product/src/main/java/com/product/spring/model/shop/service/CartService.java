package com.product.spring.model.shop.service;

import java.util.List;

import com.product.spring.model.shop.dto.CartDTO;

public interface CartService {
	public void insert(CartDTO vo);
	public List<CartDTO> listCart();
	public void delete(int cart_id);
	public void modifyCart(CartDTO vo);
	public int sumMoney();
	public int countCart(int product_id);
	public void updateCart(CartDTO vo);
}
