package com.user.model;

import java.sql.Date;
import java.sql.Timestamp;

public class UserVO implements java.io.Serializable {
	private Integer userId;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userIdentity;
	private Date userBirthday;
	private Timestamp userRegistration;

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userPhone=" + userPhone + ", userIdentity=" + userIdentity
				+ ", userBirthday=" + userBirthday + ", userRegistration=" + userRegistration + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Timestamp getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(Timestamp userRegistration) {
		this.userRegistration = userRegistration;
	}

}
