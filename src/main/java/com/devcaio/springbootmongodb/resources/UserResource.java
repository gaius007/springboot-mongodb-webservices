package com.devcaio.springbootmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcaio.springbootmongodb.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User(); 
		User alex = new User();
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(users);
	}
	
	
}
