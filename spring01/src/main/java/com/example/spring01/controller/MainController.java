package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// URL pattern mapping으로 get이나 post 방식 모두 사용 가능 (/:root)
	@RequestMapping("/")
	public String main(Locale locale, Model model) {
		// Model : 데이터를 담는 공간, map(K, V)
		logger.info("main called");
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
	/* 구구단 */
	@RequestMapping(value="gugu.do", method=RequestMethod.GET)
	public String gugu(int dan, Model model) {
		logger.info("gugu called");
		String result = "";
		for(int i=1; i<10; i++) {
			result += dan + " * " + i + " = " + dan*i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu";	// 경로 리턴
	}
	
	/* 테스트 */
	@RequestMapping("test.do")
	public void test() {
		// return type이 void인 경우 RequestMapping과 동일한 페이지로 이동함.
		logger.info("test called");
	}
	
	/* test/doA 와 mapping */
	@RequestMapping("test/doA")
	public String doA(Model model) {
		logger.info("doA called");
		model.addAttribute("message", "doA에서 넘어왔습니다.");
		return "test/doB"; // A 누르면 B로 가도록 하기
	}
	
	/* test/doB 와 mapping */
	@RequestMapping("test/doB")
	public void doB() {
		logger.info("doB called");
	}
	
	/** test/doC 와 mapping : ModelAndView로 객체와 출력 페이지를 함께 전달하기 
	 * Model : 데이터 저장소, View : 출력 화면
	 * 데이터와 forward할 페이지 정보를 함께 전달
	 * - forward : 주소가 바뀌지 않고 화면 전환(대량의 데이터 전달)
	 * - redirect : 주소가 바뀌고 화면 전환(소량의 데이터 전달, get 방식)
	 * */
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		logger.info("doC called");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", new ProductDTO("샤프", 1000)); // 값 넘김
		return new ModelAndView("test/doC", "map", map);
	}

}
