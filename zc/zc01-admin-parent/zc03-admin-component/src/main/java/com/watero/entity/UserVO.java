package com.watero.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserVO {
	private Long id;
	private String userName;
	private String nickName;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT 8")
	private Date createDate;
	private int roleDesc;
	private String textArea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(int roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userName=" + userName + ", nickName=" + nickName + ", password=" + password
				+ ", createDate=" + createDate + ", roleDesc=" + roleDesc + ", textArea=" + textArea + "]";
	}

}
