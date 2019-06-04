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

import com.example.spring01.model.dto.AddressDTO;
import com.example.spring01.service.AddressService;


@Controller
public class AddressController {
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	@Inject
	AddressService addressService;
	
	@RequestMapping("address/list.do")
	public String addressList(Model model) {
		List<AddressDTO> list = addressService.addressList();
		model.addAttribute("list", list);
		logger.info("list: " + list.toString());
		return "address/address_list";
	}
	
	@RequestMapping("address/write.do")
	public String write(Model model) {
		return "address/address_write";
	}
	
	/**
	 * @ModelAttribute: 폼에서 입력한 데이터가 저장됨
	 * @ModelAttribute MemberDTO dto: request.getParameter로 값을 전달하지 않아도 됨
	 * */
	@RequestMapping("address/insert.do")	// 사용자가 요청한 주소
	public String insert(@ModelAttribute AddressDTO dto) {
		addressService.insertAddress(dto);
		// redirect를 안붙일 경우 forward가 되어서 주소가 바뀌지 않음(redirect로 주소 바꾸기)
		return "redirect:/address/list.do";
	}
	
	/**
	 * view.do?userid=hello 일 경우 @RequestParam String userid 변수에 hello가 저장됨
	 * @ModelAttribute: 폼의 전체 데이터를 전달함(즉 dto)
	 * @RequestParam: 폼의 개별 데이터를 전달함
	 * */
	@RequestMapping("address/view.do")
	public String view(@RequestParam int addr_no, Model model) {
		model.addAttribute("dto", addressService.viewAddress(addr_no));
		return "address/address_view";
	}
	
	@RequestMapping("address/update.do")
	public String update(@ModelAttribute AddressDTO dto) {
		logger.info("업데이트 글번호: " + dto.getAddr_no() + ",  /이름: " + dto.getAddr_name());
		addressService.updateAddress(dto); // 레코드 수정
		return "redirect:/address/list.do";
	}
	
	@RequestMapping("address/delete.do")
	public String delete(@ModelAttribute AddressDTO dto) {
		logger.info("삭제 글번호: " + dto.getAddr_no());
		addressService.deleteAddress(dto.getAddr_no());
		return "redirect:/address/list.do";
	}
}
