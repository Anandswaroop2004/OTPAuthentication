package com.example.otpauthentication.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	
	public AppUser registerUser(AppUser user) {
		return repository.save(user);
	}
	
	public boolean loginUser(String name, String password) {
		System.out.println("Service method : name : " + name + ", password: " + password);
		AppUser user = repository.findByName(name);
		System.out.println("============================================================");
		System.out.println(user);
		if(user != null) {
			if(user.password.equals(password)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

}
