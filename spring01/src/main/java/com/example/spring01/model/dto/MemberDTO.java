package com.example.spring01.model.dto;

import java.util.Date;

public class MemberDTO {
	private String userId;
	private String password;
	private String name;
	private String email;
	private Date joinDate;

	public MemberDTO(String userId, String password, String name, String email, Date joinDate) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}

	public MemberDTO() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "MemberDTO [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", joinDate=" + joinDate + "]";
	}

}
