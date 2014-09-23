package com.tpokora.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@NamedQuery(
		name = "findTaskByUserId",
		query = "FROM TaskEntity WHERE user_id = :user_id ORDER BY dueDate")
@Entity
@Table(name="tasks")
public class TaskEntity {
	
	private int id;
	private String task;
	private Date dueDate;
	private int userId;
	
	public TaskEntity() {}
	
	@Id
	@GeneratedValue
	@Column(name = "task_id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Size(min = 3, max = 255)
	@Column(name = "task")
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	@Column(name = "dueDate")
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
