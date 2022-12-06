package com.user.model;

import java.util.*;

public interface UserDAO_interface {

		public void insert(UserVO userVO);
		public void update(UserVO userVO);
		public void delete(Integer userId);
		public UserVO findByPrimaryKey(Integer userId);
		public UserVO findByUserEmail(String userEmail);
		public String pwdhash(String userPassword);
		public List<UserVO> getAll();
		public List<UserVO> findByEmail(String userEmail);
}
