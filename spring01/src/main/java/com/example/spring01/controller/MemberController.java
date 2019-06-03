package com.example.spring01.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

/**
 * @Controller: 현재 클래스를 controller bean으로 등록시킴
 * */
@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;

	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		model.addAttribute("list", list);
		logger.info("list: " + list.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, new Locale("ko", "KR"));
		String formattedDate = dateFormat.format(date);
		logger.info("formattedDate: " + formattedDate);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "member/member_list";
	}
	
}
