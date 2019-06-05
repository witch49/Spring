package com.product.spring.model.shop.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private int product_id;
	private String product_name;
	private int product_price;
	private String description;
	private String picture_url;
	private MultipartFile file1;// 상품 이미지 파일

	public ProductDTO(int product_id, String product_name, int product_price, String description, String picture_url,
			MultipartFile file1) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.description = description;
		this.picture_url = picture_url;
		this.file1 = file1;
	}

	public ProductDTO() {

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

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescroption(String description) {
		this.description = description;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", description=" + description + ", picture_url=" + picture_url + ", file1=" + file1
				+ "]";
	}

}
