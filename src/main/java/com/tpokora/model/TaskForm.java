package com.tpokora.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class TaskForm {
	private int taskId;
	private String task;
	private Date dueDate;
	private int userId;
	
	public TaskForm() {}
	
	public TaskForm(int userId) {
		this.userId = userId;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	@NotNull
	@Size(min = 3, max = 255)
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Future
	public Date getDueDate() {
		return dueDate;
	}
	
	public String getFormatedDate() {
		String formatedDate = new SimpleDateFormat("dd/MM/yyyy").format(dueDate);
		return formatedDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
