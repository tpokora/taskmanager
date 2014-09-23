package com.tpokora.dao;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tpokora.entity.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final String UPDATE_PASSWORD_SQL =
			"update users set password = ?, enabled = ? where username = ?";
	private static final String INSERT_INTO_AUTHORITIES =
			"insert into authorities values(?, ?)";
	@Inject 
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(UserEntity user, String password) {
		sessionFactory.getCurrentSession().save(user);
		jdbcTemplate.update(
				UPDATE_PASSWORD_SQL, password, 1,  user.getUsername());
		jdbcTemplate.update(INSERT_INTO_AUTHORITIES, user.getId(), "user");
		
	}

	@Override
	public UserEntity findByLogin(String login) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery("findUserByLogin");
		q.setParameter("username", login);
		return (UserEntity) q.uniqueResult();
	}

}
