package com.product.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.product.spring.model.shop.dto.CartDTO;
import com.product.spring.model.shop.service.CartService;
import com.product.spring.upload.UploadController;

@Controller
public class CartController {
	private static final Logger LOG = LoggerFactory.getLogger(UploadController.class); 
	
	@Inject
	CartService cartService;
	
	// 1. 장바구니 추가
	@RequestMapping("shop/cart/insert.do")
	public String insert(@ModelAttribute CartDTO vo, HttpSession session) {
		//String user_id = (String) session.getAttribute("user_id");
		//vo.setUserId(user_id);
		
		// 장바구니에 기존 상품이 있는지 검사
		//int count = cartService.countCart(vo.getProductId(), user_id);
		
		int count = cartService.countCart(vo.getProduct_id());
		LOG.trace("--------------------------------아이디는 "+vo.getProduct_id());
		LOG.trace("--------------------------------개수는 " + count);
		//count == 0 ? cartService.updateCart(vo) : cartService.insert(vo);
		if (count == 0)
			cartService.insert(vo);
		else
			cartService.updateCart(vo);
		
		return "redirect:list.do";
		//return "redirect:../product/list.do";
	}
	
	
	// 2. 장바구니 목록
	@RequestMapping("shop/cart/list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		//String user_id = (String) session.getAttribute("user_id");	// session에 저장된 user id
		Map<String, Object> map = new HashMap<>();
		//List<CartVO> list = cartService.listCart(user_id);	// 장바구니 정보
		//int sumMoney = cartService.sumMoney(user_id);
		List<CartDTO> list = cartService.listCart();	// 장바구니 정보
		int sumMoney = cartService.sumMoney(); // 장바구니 전체 금액 호출
		// 장바구니 전체 금액에 따라 배송비 구분
		// 배송료(5만원 이상: 무료, 미만: 2500원)
		int fee = sumMoney >= 50000 ? 0 : 2500;
		map.put("list", list);	// 장바구니 정보를 map에 저장
		map.put("count", list.size());	// 장바구니 상품의 유무
		map.put("sumMoney", sumMoney);	// 장바구니 전체 금액
		map.put("fee", fee);	// 배송 금액
		map.put("allSum", sumMoney + fee);	// 주문 상품 전체 금액
		mav.setViewName("shop/cart/cart_list");	// view(jsp)의 이름 저장
		mav.addObject("map", map);	// map 변수 저장
		return mav;
	}
	
	
	// 3. 장바구니 삭제
	@RequestMapping("shop/cart/delete.do")
	public String delete(@RequestParam int cart_id) {
		cartService.delete(cart_id);
		return "redirect:list.do";
	}
	
	
	// 4. 장바구니 수정
	@RequestMapping("shop/cart/update.do")
	public String update(@RequestParam int[] amount, @RequestParam int[] product_id, HttpSession session) {
		//String user_id = (String) session.getAttribute("user_id"); // session id
		// 레코드의 개수만큼 반복문 실행
		for(int i=0; i<product_id.length; i++) {
			CartDTO vo = new CartDTO();
			//vo.setUserId(user_id);
			vo.setAmount(amount[i]);
			vo.setProduct_id(product_id[i]);
			cartService.modifyCart(vo);
		}
		
		return "redirect:list.do";
		
	}
}
