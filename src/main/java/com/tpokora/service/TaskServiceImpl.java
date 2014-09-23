package com.tpokora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tpokora.dao.TaskDAO;
import com.tpokora.entity.TaskEntity;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDAO taskDAO;

	@Override
	@Transactional
	public List<TaskEntity> getAllTasks(int userId) {
		return taskDAO.getAllTasks(userId);
	}

	@Override
	@Transactional
	public void addTask(TaskEntity task) {
		taskDAO.addTask(task);
	}
	
	@Override
	@Transactional
	public void deleteTask(int taskId) {
		taskDAO.deleteTask(taskId);
	}

}
