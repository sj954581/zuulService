package com.blogUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogUser.model.BlogUser;
import com.blogUser.service.BlogUserService;

@RestController
public class BlogUserController {
	
	@Autowired
	BlogUserService blogUserService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getTest() {
		String str = "Hey!!! test from BlogUser Srevice";
		return str;
	}

	@RequestMapping(value = "/blogUser", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllBlogUsers() {
		
		List<BlogUser> allBlogUsers = blogUserService.getAllBlogUsers();
		return new ResponseEntity<>(allBlogUsers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blogUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserById(@PathVariable int id) {

		try {
			BlogUser blogUser = blogUserService.getBlogUserbyId(id);
			return new ResponseEntity<Object>(blogUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Blog User not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/blogUser", method = RequestMethod.POST)
	public String createUser(@RequestBody BlogUser blogUser) {

		try {
			String message = blogUserService.createBlogUser(blogUser);
			return message;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
