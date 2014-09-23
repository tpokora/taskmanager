package com.tpokora.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tpokora.entity.TaskEntity;
import com.tpokora.entity.UserEntity;
import com.tpokora.model.TaskForm;
import com.tpokora.model.UserLoginForm;
import com.tpokora.service.TaskService;
import com.tpokora.service.UserService;

@Controller
@SessionAttributes("suser")
@RequestMapping("/")
public class LoginController {
	private static final Logger log = 
			Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin(
			@ModelAttribute("error") String error,
			@ModelAttribute("logout") String logout) {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String postLoginForm(
			@ModelAttribute("user") UserLoginForm userLogin,
			Model model) {
		return "login";
	}

	@RequestMapping(value = "main/tasklist", method = RequestMethod.GET)
	public String aprocessLoginForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserEntity suser = userService.findByLogin(auth.getName());
		suser.setTaskList(toTaskList(taskService.getAllTasks(suser.getId())));
		System.out.println("Logged as: #" +  suser.getId() + " " + suser.getUsername());
		model.addAttribute("suser", suser);
		model.addAttribute("task", new TaskForm());
		return "main";
	}
	
	private static List<TaskForm> toTaskList(List<TaskEntity> tasklist) {
		List<TaskForm> list = new ArrayList<TaskForm>();
		for(TaskEntity task : tasklist) {
			TaskForm t = new TaskForm();
			t.setTaskId(task.getId());
			t.setTask(task.getTask());
			t.setDueDate(task.getDueDate());
			list.add(t);
		}
		return list;
	}
}
