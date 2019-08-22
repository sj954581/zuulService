package com.blogUser.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogUser.dao.BlogUserDao;

import com.blogUser.model.BlogUser;

@Service
public class BlogUserService {
	
	@Autowired
	BlogUserDao blogUserDao;

	public BlogUser getBlogUserbyId(int id) throws Exception {

		Optional<BlogUser> blogUser = blogUserDao.findById(id);

		if (blogUser.isPresent()) {
			return blogUser.get();
		} else {
			throw new Exception("BlogUser not found");
		}
	}
	
	public List<BlogUser> getAllBlogUsers() {

		List<BlogUser> blogUserList = new ArrayList<>();
		Iterable<BlogUser> list = blogUserDao.findAll();

		for (BlogUser blogUser : list) {
			blogUserList.add(blogUser);
		}
		return blogUserList;
	}
	
	
	public String createBlogUser(BlogUser blogUser) throws Exception {

		if (!isBlogUserExist(blogUser)) {
			BlogUser createdBlogUser = blogUserDao.save(blogUser);
			return "Blog user created successfully with id : " + createdBlogUser.getUser_id();
		} else {
			throw new Exception("Blog User already exists");
		}
	}
	
	public boolean isBlogUserExist(BlogUser blogUser) {

		Iterable<BlogUser> list = blogUserDao.findAll();

		for (BlogUser user : list) {
			if (user.getUser_email() .equals(blogUser.getUser_email())) {
				return true;
			}
		}
		return false;
	}

}
