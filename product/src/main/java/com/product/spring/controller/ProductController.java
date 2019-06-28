package com.product.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.product.spring.model.shop.service.ProductService;

@Controller
//@RequestMapping("/spring/shop/product/*")	// 공통적인 URL Mapping
public class ProductController {
	@Inject
	ProductService productService;

	// 1. 상품 전체 목록
	@RequestMapping("shop/product/list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("shop/product/product_list");	// 이동할 페이지 이름
		mav.addObject("list", productService.listProduct());	// 데이터 저장
		return mav;	// 페이지 이동
	}
	
	// 2. 상품 상세보기
	@RequestMapping("shop/product/detail/{product_id}")
	public ModelAndView detail(@PathVariable("product_id") int product_id, ModelAndView mav) {
		mav.setViewName("shop/product/product_detail");
		mav.addObject("vo", productService.detailProduct(product_id));
		return mav;
	}

}
