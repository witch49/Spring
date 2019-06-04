package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.AddressDAO;
import com.example.spring01.model.dto.AddressDTO;

@Service
public class AddressServiceImpl implements AddressService {

	@Inject
	AddressDAO addressDao;
	
	@Override
	public List<AddressDTO> addressList() {
		return addressDao.addressList();
	}

	@Override
	public void insertAddress(AddressDTO vo) {
		addressDao.insertAddress(vo);
	}

	@Override
	public AddressDTO viewAddress(int addr_no) {
		return addressDao.viewAddress(addr_no);
	}

	@Override
	public void deleteAddress(int addr_no) {
		addressDao.deleteAddress(addr_no);
	}

	@Override
	public void updateAddress(AddressDTO vo) {
		addressDao.updateAddress(vo);
	}

}
