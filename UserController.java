package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService service;
	
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login"; 
	}
	
	@PostMapping("/Register")
	public String registerUser(@RequestParam("un") String name, @RequestParam("ua") String age, @RequestParam("ue") String email, @RequestParam("up") String phone, @RequestParam("upwd") String password ) {
		AppUser user = new AppUser(name, age, email, phone, password);
		AppUser savedUser = service.registerUser(user);
		if(savedUser != null) {
			return "login";
		}
		return "index";
	}
	
	@PostMapping("/loginuser")
	public String loginUser(@RequestParam("un") String name, @RequestParam("pw") String password) {
		System.out.println("username : " + name + " , password: " + password);
		boolean isuser = service.loginUser(name, password);
		System.out.println("isUser: " + isuser);
		if(isuser) {
			return "dashboard";
		}
		else {
			return "login";
		}
	}
}
