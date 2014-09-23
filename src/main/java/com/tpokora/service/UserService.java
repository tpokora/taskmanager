package com.tpokora.service;

import org.springframework.validation.Errors;

import com.tpokora.entity.UserEntity;

public interface UserService {
	public boolean create(UserEntity user, String password, Errors errors);
	public UserEntity findByLogin(String login);
}
