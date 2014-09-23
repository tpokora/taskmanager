package com.tpokora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.tpokora.dao.UserDAO;
import com.tpokora.entity.UserEntity;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserDAO userDAO;
	
	@Override
	@Transactional(readOnly = false)
	public boolean create(UserEntity user, String password, Errors errors) {
		valdiateLogin(user.getUsername(), errors);
		boolean valid = !errors.hasErrors();
		if(valid) {
			userDAO.create(user, password);
		}
		return valid;
	}

	@Override
	@Transactional
	public UserEntity findByLogin(String login) {
		return userDAO.findByLogin(login);
	}
	
	private void valdiateLogin(String username, Errors errors) {
		if(userDAO.findByLogin(username) != null) {
			errors.rejectValue("username", "error.duplicate.registration.login",
					new String[] { username }, null);
		}
	}
}
