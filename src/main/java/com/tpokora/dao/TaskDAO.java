package com.tpokora.dao;

import java.util.List;

import com.tpokora.entity.TaskEntity;

public interface TaskDAO {
	public List<TaskEntity> getAllTasks(int userId);
	public TaskEntity getTask(int id);
	public void addTask(TaskEntity task);
	public void deleteTask(int taskId);
}
