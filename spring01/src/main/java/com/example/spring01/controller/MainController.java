package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// URL pattern mapping으로 get이나 post 방식 모두 사용 가능 (/:root)
	@RequestMapping("/")
	public String main(Locale locale, Model model) {
		// Model : 데이터를 담는 공간, map(K, V)
		logger.info("main");
		model.addAttribute("message", "저의 홈페이지입니다.");
		return "main";	// 경로 리턴
	}
	
	/* 방법 1 */
//	@RequestMapping(value="gugu.do", method=RequestMethod.GET)
//	public String gugu(Model model) {
//		logger.info("gugu");
//		int dan = 7;
//		String result = "";
//		for(int i=1; i<10; i++) {
//			result += dan + " * " + i + " = " + dan*i + "<br>";
//		}
//		model.addAttribute("result", result);
//		return "test/gugu";	// 경로 리턴
//	}
	
	/* 방법 2 */
	@RequestMapping(value="gugu.do", method=RequestMethod.GET)
	public String gugu(int dan, Model model) {
		logger.info("gugu");
		String result = "";
		for(int i=1; i<10; i++) {
			result += dan + " * " + i + " = " + dan*i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu";	// 경로 리턴
	}
	
	@RequestMapping(value="test.do", method=RequestMethod.GET)
	public String test() {
		return "";
	}


}
