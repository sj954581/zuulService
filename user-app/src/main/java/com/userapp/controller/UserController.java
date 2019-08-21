package com.userapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userapp.model.User;
import com.userapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTest() {
		String str = "Hello !!! this is test from User Srevice ";
		return str;
	}

	@RequestMapping(value = "/userlogin/{id}/{password}", method = RequestMethod.GET)
	public ResponseEntity<Object> loginById(@PathVariable int id,@PathVariable String password) {

		try {
			User user = userService.loginbyId(id,password);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("invalid Login Credentials.Login failed...", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String createUser(@RequestBody User userDto) {

		try {
			String message = userService.createUser(userDto);
			return message;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllUsers() {

		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable int id, @RequestBody User userDto) {

		try {
			User user = userService.updateUser(id, userDto);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserById(@PathVariable int id) {

		try {
			User user = userService.getUserbyId(id);
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("user not found", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUserbyId(@PathVariable int id) {

		try {
			userService.deleteUserbyId(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value = "/fbLogin", method = RequestMethod.GET)
    public Principal getUser(Principal user) {
        return user;
    }
}
