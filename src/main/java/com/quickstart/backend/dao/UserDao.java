package com.quickstart.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickstart.backend.models.User;

public interface UserDao extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User findByUsername(String username);
}
