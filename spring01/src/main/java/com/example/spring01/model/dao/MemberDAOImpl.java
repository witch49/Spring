package com.example.spring01.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.MemberDTO;

/**
 * @Repository:
 *  컨트롤러나 모델을 사용자가 직접 관리해도 되지만 Spring에서는 의존성 주입(DI)이라 하여 Spring이 관리하도록 함.
 *  (서버가 구동되면서 자동으로 메모리에 올려주고,
 *   이렇게 올라가있는 객체들은 new XXX 으로 생성하지 않아도 @Inject 어노테이션을 붙여 객체를 삽입할 수 있음)
 * */
@Repository
public class MemberDAOImpl implements MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	@Inject
	SqlSession sqlSession;	// SqlSession을 사용하면 자동으로 commit됨
	
	@Override
	public List<MemberDTO> memberList() {
		// src/main/resources/mappers/memberMapper.xml 의 namespace(member).id(memberList)
		return sqlSession.selectList("member.memberList");
	}

	@Override
	public void insertMember(MemberDTO vo) {
		sqlSession.insert("member.insertMember", vo);
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember", userid);
	}

	@Override
	public void deleteMember(String userid) {

	}

	@Override
	public void updateMember(MemberDTO vo) {
		sqlSession.update("member.updateMember", vo);
	}

	@Override
	public boolean checkPwd(String userid, String passwd) {
		boolean result = false;
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		int count = sqlSession.selectOne("member.checkPw", map);
		if (count == 1)
			result =  true;
		return result;
	}

}
