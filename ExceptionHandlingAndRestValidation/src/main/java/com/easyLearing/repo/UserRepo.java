package com.easyLearing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyLearing.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUserId(int id);

}
