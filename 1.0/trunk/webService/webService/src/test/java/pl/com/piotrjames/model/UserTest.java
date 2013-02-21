package pl.com.piotrjames.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crystalfirge.dao.interfaces.UserDao;

import pl.com.piotrjames.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/app-config.xml" })
public class UserTest {
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Before
	public void beforeUser() {
		User user = new User();
		user.setName("piotrjames");
		userDao.saveUser(user);
	}

	@Test
	public void checkPersistedClientData() {
		Assert.assertEquals(true, isAnyUserPersistedInToBD());
		
		User u = userDao.getAllUser().get(0);
		
		System.out.println(u.getName());
	}

	private boolean isAnyUserPersistedInToBD() {
		return userDao.getAllUser().size() > 0;
	}
}
