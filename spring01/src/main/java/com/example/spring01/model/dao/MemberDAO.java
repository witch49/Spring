package com.example.spring01.model.dao;

import java.util.List;
import com.example.spring01.model.dto.MemberDTO;

public interface MemberDAO {
	public List<MemberDTO> memberList();
	public void insertMember(MemberDTO vo);
	public MemberDTO viewMember(String userId);
	public void deleteMember(String userId);
	public void updateMember(MemberDTO vo);
	public boolean checkPwd(String userId, String password);

}
