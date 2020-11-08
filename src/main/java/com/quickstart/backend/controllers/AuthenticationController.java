package com.quickstart.backend.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickstart.backend.models.User;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	
	@PostMapping(value="logon")
	@ResponseBody
	public String logon(@Valid User user) {
		return "Hello";
	}
}
