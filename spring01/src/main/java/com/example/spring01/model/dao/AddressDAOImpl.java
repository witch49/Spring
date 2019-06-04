package com.example.spring01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.AddressDTO;

@Repository
public class AddressDAOImpl implements AddressDAO {
	private static final Logger logger = LoggerFactory.getLogger(AddressDAOImpl.class);

	@Inject
	SqlSession sqlSession;	// SqlSession을 사용하면 자동으로 commit됨
	
	@Override
	public List<AddressDTO> addressList() {
		// src/main/resources/mappers/memberMapper.xml 의 namespace(member).id(memberList)
		return sqlSession.selectList("address.addressList");
	}

	@Override
	public void insertAddress(AddressDTO vo) {
		sqlSession.insert("address.insertAddress", vo);
	}

	@Override
	public AddressDTO viewAddress(int addr_no) {
		return sqlSession.selectOne("address.viewAddress", addr_no);
	}

	@Override
	public void deleteAddress(int addr_no) {
		sqlSession.delete("address.deleteAddress", addr_no);
	}

	@Override
	public void updateAddress(AddressDTO vo) {
		logger.info("AddrDaoImpl------업데이트 번호: " + vo.getAddr_no() + " /이름: " + vo.getAddr_name());
		sqlSession.update("address.updateAddress", vo);
	}

}
