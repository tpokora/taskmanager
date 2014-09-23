package com.tpokora.service;

import java.util.List;

import com.tpokora.entity.TaskEntity;

public interface TaskService {
	public List<TaskEntity> getAllTasks(int userId);
	public void addTask(TaskEntity task);
	public void deleteTask(int id);
}
