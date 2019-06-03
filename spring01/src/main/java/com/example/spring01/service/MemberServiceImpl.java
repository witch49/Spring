package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

/**
 * @Service
 * */
@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;

	@Override
	public List<MemberDTO> memberList() {
		return memberDao.memberList();
	}

	@Override
	public void insertMember(MemberDTO vo) {

	}

	@Override
	public MemberDTO viewMember(String userId) {
		return null;
	}

	@Override
	public void deleteMember(String userId) {

	}

	@Override
	public void updateMember(MemberDTO vo) {

	}

	@Override
	public boolean checkPwd(String userId, String password) {
		return false;
	}

}
