package com.example.spring01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;
import com.mysql.cj.xdevapi.JsonArray;

/**
 * @RestController :
 * 	Ajax 처리 전용 컨트롤러(백그라운드에서 실행)
 * 	Spring 4.0 이상부터 사용 가능
 * -----------------------------------------------------------------------
 * @RestController 대신 @Controller를 사용해도 됨
 * 현업에서는 3.0 ver 를 사용하므로
 * 3.0 ver 에서 @Controller를 사용한다면 반드시 @ResponseBody를 달아줘야 함.
 * @RestController는 @ResponseBody 생략 가능
 * 위 코드는 페이지로 이동하는 것이 아리라 데이터가 전달되는 것임.
 * */
@RestController
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	/**
	 * @ResponseBody : JSON 형식으로 데이터를 리턴
	 * */
	@ResponseBody
	@RequestMapping("test/doE")
	public ProductDTO doF() {
		// JSON 데이터가 처리됨
		logger.info("doE called");
		return new ProductDTO("냉장고", 500000);
	}
	
}
