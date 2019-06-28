package com.product.spring.model.shop.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.product.spring.model.shop.dao.ProductDAO;
import com.product.spring.model.shop.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAO productDao;
	
	// 1. 상품 목록
	@Override
	public List<ProductDTO> listProduct() {
		return productDao.listProduct();
	}

	// 2. 상품 상세
	@Override
	public ProductDTO detailProduct(int product_id) {
		return productDao.detailProduct(product_id);
	}

	// 3. 상품 수정
	@Override
	public void updateProduct(ProductDTO dto) {

	}

	// 4. 상품 삭제
	@Override
	public void deleteProduct(ProductDTO dto) {

	}

	@Override
	public void insertProduct(ProductDTO dto) {

	}

	@Override
	public String fileInfo(int product_id) {
		return null;
	}

}
