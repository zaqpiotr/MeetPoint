package com.crystalfirge.dao.interfaces;

import java.util.List;

import pl.com.piotrjames.model.User;

public interface UserDao {	 
	 void saveUser(User user);
	 List<User> getAllUser();
}
