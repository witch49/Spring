package com.product.spring.model.shop.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.product.spring.model.shop.dao.CartDAO;
import com.product.spring.model.shop.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	@Inject
	CartDAO cartDao;
	
	// 1. 장바구니 추가
	@Override
	public void insert(CartDTO vo) {
		cartDao.insert(vo);
	}
	
	// 2. 장바구니 목록
	@Override
	public List<CartDTO> listCart() {
		return cartDao.listCart();
	}
	
	// 3. 장바구니 삭제
	@Override
	public void delete(int cart_id) {
		cartDao.delete(cart_id);
	}
	
	// 4. 장바구니 수정
	@Override
	public void modifyCart(CartDTO vo) {
		cartDao.modifyCart(vo);
	}
	
	// 5. 장바구니 금액 합계
	@Override
	public int sumMoney() {
		return cartDao.sumMoney();
	}
	
	// 6. 장바구니 상품 확인
	@Override
	public int countCart(int product_id) {
		return cartDao.countCart(product_id);
	}
	
	// 7. 장바구니 상품 수량 변경
	@Override
	public void updateCart(CartDTO vo) {
		cartDao.updateCart(vo);
	}
}
