package com.quickstart.backend.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickstart.backend.dao.UserDao;
import com.quickstart.backend.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transient
	public User create(User user) {
		return this.userDao.save(user);
	}
	
	@Transient
	public User update(User user) {
		User newU = this.em.merge(user);
		return newU;
	}

}
