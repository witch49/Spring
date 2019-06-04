package com.example.spring01.model.dto;

public class AddressDTO {
	private int addr_no;
	private String addr_name;
	private String addr_tel;
	private String addr_email;
	private String addr_address;
	private String addr_memo;

	public AddressDTO(int addr_no, String addr_name, String addr_tel, String addr_email, String addr_address,
			String addr_memo) {
		this.addr_no = addr_no;
		this.addr_name = addr_name;
		this.addr_tel = addr_tel;
		this.addr_email = addr_email;
		this.addr_address = addr_address;
		this.addr_memo = addr_memo;
	}

	public AddressDTO() {

	}

	public int getAddr_no() {
		return addr_no;
	}

	public void setAddr_no(int addr_no) {
		this.addr_no = addr_no;
	}

	public String getAddr_name() {
		return addr_name;
	}

	public void setAddr_name(String addr_name) {
		this.addr_name = addr_name;
	}

	public String getAddr_tel() {
		return addr_tel;
	}

	public void setAddr_tel(String addr_tel) {
		this.addr_tel = addr_tel;
	}

	public String getAddr_email() {
		return addr_email;
	}

	public void setAddr_email(String addr_email) {
		this.addr_email = addr_email;
	}

	public String getAddr_address() {
		return addr_address;
	}

	public void setAddr_address(String addr_address) {
		this.addr_address = addr_address;
	}

	public String getAddr_memo() {
		return addr_memo;
	}

	public void setAddr_memo(String addr_memo) {
		this.addr_memo = addr_memo;
	}

	@Override
	public String toString() {
		return "AddressDTO [addr_no=" + addr_no + ", addr_name=" + addr_name + ", addr_tel=" + addr_tel
				+ ", addr_email=" + addr_email + ", addr_address=" + addr_address + ", addr_memo=" + addr_memo + "]";
	}

}
