package com.userapp.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userapp.dao.UserDao;
import com.userapp.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	
	public User loginbyId(int id,String password) throws Exception {

		Optional<User> user = userDao.findByIdPswrd(id,password);

		if (user.isPresent()) {
			return user.get();
		} else {
			throw new Exception("invalid Login Credentials.Login failed...");
		}
	}


	public String createUser(User userDto) throws Exception {

		if (!isUserExist(userDto)) {
			User createdUser = userDao.save(userDto);
			return "user created successfully with id : " + createdUser.getId();
		} else {
			throw new Exception("user already exists");
		}
	}

	public User getUserbyId(int id) throws Exception {

		Optional<User> user = userDao.findById(id);

		if (user.isPresent()) {
			return user.get();
		} else {
			throw new Exception("user not found");
		}
	}

	public User updateUser(int id, User userDto) throws Exception {

		User currentUser = userDao.getUserbyId(id);

		if (currentUser != null) {
			currentUser.setName(userDto.getName());
			currentUser.setEmail(userDto.getEmail());
			currentUser.setPhoneNumber(userDto.getPhoneNumber());

			User user = userDao.save(currentUser);
			return user;
		} else {
			throw new Exception("user not found with id : " + id);
		}
	}

	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<>();
		Iterable<User> list = userDao.findAll();

		for (User user : list) {
			userList.add(user);
		}
		return userList;
	}

	public boolean isUserExist(User userDto) {

		Iterable<User> list = userDao.findAll();

		for (User user : list) {
			if (user.getEmail().equals(userDto.getEmail()) && user.getPhoneNumber().equals(userDto.getPhoneNumber())) {
				return true;
			}
		}
		return false;
	}

	public String deleteUserbyId(int id) throws Exception {

		User user = userDao.getUserbyId(id);
		if (user != null) {
			userDao.delete(user);
			return "user deleted successfully";
		} else {
			return "no user with given id";
		}
	}

	public String searchUser(int keyword) {
		
		
		if(keyword < 0) {
			return "shashi";
		} else {
//			System.out.println("keyword === "+ keyword);
//			User user = userDao.getUserbyId(keyword);
//			return user.getName();
			return "raju";
		}
		
		
	}
}
