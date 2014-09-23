package com.tpokora.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tpokora.entity.TaskEntity;

@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TaskEntity> getAllTasks(int userId) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery("findTaskByUserId");
		q.setParameter("user_id", userId);
		return q.list();
		
	}

	@Override
	public TaskEntity getTask(int id) {
		return null;
	}

	@Override
	public void addTask(TaskEntity task) {
		sessionFactory.getCurrentSession().save(task);
	}
	
	@Override
	public void deleteTask(int taskId) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM TaskEntity WHERE task_id = " + taskId);
		TaskEntity task = (TaskEntity) q.uniqueResult();
		session.delete(task);
	}

}
