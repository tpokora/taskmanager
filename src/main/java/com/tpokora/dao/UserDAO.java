package com.tpokora.dao;

import com.tpokora.entity.UserEntity;

public interface UserDAO {
	//public void create(UserEntity user);
	public void create(UserEntity user, String password);
	public UserEntity findByLogin(String login);
	
}
