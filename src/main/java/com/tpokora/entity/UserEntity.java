package com.tpokora.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tpokora.model.TaskForm;

@NamedQuery(
		name = "findUserByLogin",
		query = "from UserEntity where username = :username")
@Entity
@Table(name = "users")
public class UserEntity {
	private int id;
	private String username, email;
	private boolean enabled;
	private List<TaskForm> taskList;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@OneToMany
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@NotNull
	@Size(min = 3, max = 20)
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@NotNull
	@Size(min = 6, max = 30)
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotNull
	@Column(name = "enabled")
	public boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Transient
	public List<TaskForm> getTaskList() {
		return taskList;
	}
	
	public void setTaskList(List<TaskForm> taskList) {
		this.taskList = taskList;
	}
}
