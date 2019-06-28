package com.product.spring.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.product.spring.model.shop.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	/* 의존성 주입 */
	@Inject
	SqlSession sqlSession;
	
	// 1. 상품 목록
	@Override
	public List<ProductDTO> listProduct() {
		return sqlSession.selectList("product.list_product");
	}

	// 2. 상품 상세
	@Override
	public ProductDTO detailProduct(int product_id) {
		return sqlSession.selectOne("product.detail_product", product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {

	}

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
