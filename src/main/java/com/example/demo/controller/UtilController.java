package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Log;
import com.example.demo.model.User;
import com.example.demo.service.LogService;
import com.example.demo.service.UserService;

public abstract class UtilController {
	@Autowired
    private LogService logService;
	
	@Autowired
    private UserService userService;
	
	public void saveLog(String resource, String description, String otherInfo){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		System.out.println("### Save log UserName: " + username);
		
		User user = userService.getUserByUsername(username);
		Log log = new Log(resource, description, otherInfo, user);
		log = logService.save(log);
    }
}
