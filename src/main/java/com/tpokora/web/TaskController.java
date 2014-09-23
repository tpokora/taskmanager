package com.tpokora.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tpokora.entity.TaskEntity;
import com.tpokora.entity.UserEntity;
import com.tpokora.model.TaskForm;
import com.tpokora.service.TaskService;

@SessionAttributes("suser")
@Controller("/")
public class TaskController {
	private static String pattern = "dd/MM/yyyy";
	private static SimpleDateFormat format = new SimpleDateFormat(pattern);
	private static final String TASK_FORM = "main";
	private static final String TASK_OK = "addtask";
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "main/new", method = RequestMethod.POST)
	public String addTaskForm(
			@ModelAttribute("task") @Valid TaskForm task,
			BindingResult result,
			@ModelAttribute("suser") UserEntity suser, 
			Model model) throws ParseException {
		model.addAttribute("suser", suser);
		if(result.hasErrors()) {
			return TASK_FORM;
		}
		else {
			taskService.addTask(toTaskEntity(task, suser.getId()));
			return TASK_OK;
		}
	}
	
	@RequestMapping(value = "main/delete/{taskId}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("taskId") int taskId) {
		taskService.deleteTask(taskId);
		return "deleteTask";
	}
	
	private static TaskEntity toTaskEntity(TaskForm task, int userId) throws ParseException {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setTask(task.getTask());
		Date dueDate = task.getDueDate();
		taskEntity.setDueDate(dueDate);
		taskEntity.setUserId(userId);
		return taskEntity;
	}
	

}
