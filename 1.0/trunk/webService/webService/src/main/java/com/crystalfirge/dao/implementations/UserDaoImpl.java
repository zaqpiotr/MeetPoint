package com.crystalfirge.dao.implementations;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.com.piotrjames.model.User;

import com.crystalfirge.dao.interfaces.UserDao;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		hibernateTemplate.saveOrUpdate(user);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		return hibernateTemplate.find("from "+User.class.getName());
	}
}
