package com.example.dao;

import com.example.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UsersDao {
	/**
	 * add users
	 * 
	 * @param users
	 */
	public void addUsers(Users users);

	/**
	 * search users
	 * 
	 * @param users
	 * @return
	 */
	public List<Users> getUsers(Users users);

	/**
	 * uodate users
	 * 
	 * @param users
	 */
	public void updateUsers(Users users);

}
