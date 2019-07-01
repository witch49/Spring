package com.product.spring.model.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.product.spring.model.shop.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO {

		@Inject
		SqlSession sqlSession;
		
		// 1. 장바구니 추가
		@Override
		public void insert(CartDTO vo) {
			sqlSession.insert("cart.insert_cart", vo);
		}
		
		// 2. 장바구니 목록
		@Override
		public List<CartDTO> listCart() {
			return sqlSession.selectList("cart.list_cart");
		}
		
		// 3. 장바구니 삭제
		@Override
		public void delete(int cart_id) {
			sqlSession.delete("cart.delete_cart", cart_id);
		}
		
		// 4. 장바구니 수정
		@Override
		public void modifyCart(CartDTO vo) {
			sqlSession.update("cart.modify_cart", vo);
		}
		
		// 5. 장바구니 금액 합계
		@Override
		public int sumMoney() {
			sqlSession.selectOne("cart.sumMoney");
			return sqlSession.selectOne("cart.sumMoney");
		}
		
		// 6. 장바구니 동일한 상품 레코드 확인
		@Override
		public int countCart(int product_id) {
			Map<String, Object> map = new HashMap<>();
			map.put("product_id", product_id);
			//map.put("user_id", user_id);
			return sqlSession.selectOne("cart.count_cart", map);
		}
		
		// 7. 장바구니 상품 수량 변경
		@Override
		public void updateCart(CartDTO vo) {
			sqlSession.update("cart.update_cart", vo);
		}
}
