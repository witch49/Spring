package com.example.spring01.service;

import java.util.List;
import com.example.spring01.model.dto.AddressDTO;

public interface AddressService {
	List<AddressDTO> addressList();
	public void insertAddress(AddressDTO vo);
	public AddressDTO viewAddress(int addr_no);
	public void deleteAddress(int addr_no);
	public void updateAddress(AddressDTO vo);

}
