package com.springboot.Crud.Application.For.Springboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.Crud.Application.For.Springboot.entity.User;
import com.springboot.Crud.Application.For.Springboot.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/retrieve")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	@PostMapping(value = "/register")
	public ResponseEntity<User> registeredUave(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<User> updateUser(@Valid @PathVariable Integer id, @RequestBody User userRequest) {
		Optional<User> optionalUser = repository.findById((id));
		User userFromDb = null;
		if (optionalUser.isPresent()) {
			userFromDb = optionalUser.get();
		}

		userFromDb.setName(userRequest.getName());
		userFromDb.setUsername(userRequest.getUsername());
		userFromDb.setMobile_number(userRequest.getMobile_number());
		userFromDb.setEmail(userRequest.getEmail());
		userFromDb.setPassword(userRequest.getPassword());

		User updatedUser = repository.save(userFromDb);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
}
