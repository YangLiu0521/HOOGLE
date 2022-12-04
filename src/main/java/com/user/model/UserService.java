package com.user.model;

import java.util.*;
import java.sql.*;

public class UserService {

	private UserDAO_interface dao;

	public UserService() {

		dao = new UserDAO();
	}

	public UserVO addUser(String userEmail, String userPassword, String userName, String userPhone, String userIdentity,
			java.sql.Date userBirthday, java.sql.Date userRegistration) {

		UserVO userVO = new UserVO();

		userVO.setUserEmail(userEmail);
		userVO.setUserPassword(userPassword);
		userVO.setUserName(userName);
		userVO.setUserPhone(userPhone);
		userVO.setUserIdentity(userIdentity);
		userVO.setUserBirthday(userBirthday);
		userVO.setUserRegistration(userRegistration);
		dao.insert(userVO);

		return userVO;
	}

	// 預留給 Struts 2 或 Spring MVC 用
	public void addUser(UserVO userVO) {
		dao.insert(userVO);
	}

	public UserVO updateUser(Integer userId, String userEmail, String userPassword, String userName, String userPhone,
			String userIdentity, java.sql.Date userBirthday, java.sql.Date userRegistration) {

		UserVO userVO = new UserVO();

		userVO.setUserId(userId);
		userVO.setUserEmail(userEmail);
		userVO.setUserPassword(userPassword);
		userVO.setUserName(userName);
		userVO.setUserPhone(userPhone);
		userVO.setUserIdentity(userIdentity);
		userVO.setUserBirthday(userBirthday);
		userVO.setUserRegistration(userRegistration);

		return dao.findByPrimaryKey(userId);
	}

	// 預留給 Struts 2 用的
	public void updateUser(UserVO userVO) {
		dao.update(userVO);
	}
	
	public void deleteUser(Integer userId) {
		dao.delete(userId);
	}
	
	public UserVO getOneUser(Integer userId) {
		return dao.findByPrimaryKey(userId);
	}
	
	public List<UserVO> getAll(){
		return dao.getAll();
	}

}
