package pl.com.piotrjames.model;

import java.util.List;

public interface UserDao {	 
	 void saveUser(User user);
	 List<User> getAllUser();
}
