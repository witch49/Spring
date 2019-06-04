package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "member/member_list";
	}
	
	@RequestMapping("member/write.do")
	public String write(Model model) {
		return "member/write";
	}
	
	/**
	 * @ModelAttribute: 폼에서 입력한 데이터가 저장됨
	 * @ModelAttribute MemberDTO dto: request.getParameter로 값을 전달하지 않아도 됨
	 * */
	@RequestMapping("member/insert.do")	// 사용자가 요청한 주소
	public String insert(@ModelAttribute MemberDTO dto) {
		memberService.insertMember(dto);
		// redirect를 안붙일 경우 forward가 되어서 주소가 바뀌지 않음(redirect로 주소 바꾸기)
		return "redirect:/member/list.do";
	}
	
	/**
	 * view.do?userid=hello 일 경우 @RequestParam String userid 변수에 hello가 저장됨
	 * @ModelAttribute: 폼의 전체 데이터를 전달함(즉 dto)
	 * @RequestParam: 폼의 개별 데이터를 전달함
	 * */
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("dto", memberService.viewMember(userid));
		return "member/view";
	}
	
	@RequestMapping("member/update.do")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		boolean result = memberService.checkPwd(dto.getUserid(), dto.getPasswd());
		logger.info("비밀번호 확인: " + result);
		
		if(result) {	// 비밀번호가 맞으면
			memberService.updateMember(dto);	// 레코드 수정
			return "redirect:/member/list.do";
		} else {	// 비밀번호가 틀리면
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());	// 날짜가 지워지지 않도록 설정
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 틀렸습니다.");
			return "member/view";	// 수정 페이지로 돌아가기
		}
		
	}
	
	@RequestMapping("member/delete.do")
	public String delete(@ModelAttribute MemberDTO dto, Model model) {
		boolean result = memberService.checkPwd(dto.getUserid(), dto.getPasswd());
		
		if(result) { // 비밀번호가 맞으면
			memberService.deleteMember(dto.getUserid());
			return "redirect:/member/list.do";
		} else { // 비밀번호가 틀리면
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date());	// 날짜가 지워지지 않도록 설정
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 틀렸습니다.");
			return "member/view";	// 수정 페이지로 돌아가기
		}
	}
	
	
}
