package com.example.spring01.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);

	@RequestMapping(value = "/error500", method = RequestMethod.GET)
	public String error500(HttpServletResponse res, Model model) {
		// response 객체의 상태 값을 정상으로 바꾸어야 error500 페이지가 제대로 보임
		res.setStatus(HttpServletResponse.SC_OK);
		logger.info("500 error 발생");
		model.addAttribute("content", "error/error500");
		return "error/error500";

	}
}
