package com.tpokora.web;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tpokora.entity.UserEntity;
import com.tpokora.model.RegisterForm;
import com.tpokora.service.UserService;

@Controller
@RequestMapping("/")
public class RegisterController {
	private static final String REG_FORM = "registerPage";
	private static final String REG_OK = "registrationOk";
	
	private static final Logger log = 
			Logger.getLogger(RegisterController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String registerForm(
			@ModelAttribute("newUser") RegisterForm regForm,
			Model model) {
		return REG_FORM;
	}
	
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String getNew() {
		return REG_OK;
	}
	
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String processRegisterForm(
			@ModelAttribute("newUser") @Valid RegisterForm regForm,
			BindingResult result) {
		convertPasswordError(result);		
		userService.create(toUser(regForm), regForm.getPassword(), result);
		return (result.hasErrors() ? REG_FORM : REG_OK);
	}
	
	private static void convertPasswordError(BindingResult result) {
		for(ObjectError error : result.getGlobalErrors()) {
			String msg = error.getDefaultMessage();
			if("registration.mismatch.password".equals(msg))
				if(!result.hasFieldErrors("password"))
					result.rejectValue("password", "registration.mismatch.password");
		}	
	}
	
	private static UserEntity toUser(RegisterForm form) {
		UserEntity user = new UserEntity();
		user.setUsername(form.getLogin());
		user.setEmail(form.getEmail());
		return user;
	}

}
