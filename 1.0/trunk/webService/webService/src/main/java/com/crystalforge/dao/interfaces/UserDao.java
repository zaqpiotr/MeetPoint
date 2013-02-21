package com.crystalforge.dao.interfaces;

import java.util.List;

import com.crystalforge.model.User;


public interface UserDao {	 
	 void saveUser(User user);
	 List<User> getAllUser();
}
