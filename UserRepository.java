package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

	AppUser findByName(String name);
    /* This fellow is giving user object which is 
      fetched by using the name you have to collect it by calling it in service class
      public boolean loginUser(String name, String password) { }
      */
}
