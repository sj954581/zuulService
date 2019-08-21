package com.userapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.userapp.dao.UserDao;
import com.userapp.model.User;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@MockBean
	UserDao userDaoMock;
	
	User user = new User();
	
//	@Before
//	public void before() {
//		//MockitoAnnotations.initMocks(this);
//	//	userDaoMock = mock(UserDao.class);
//		user.setName("shashi");
//		user.setId(5);
//		int keyword = 1;
//		System.out.println("user ..."+user);
//		System.out.println("user1111 ..."+userDaoMock.getUserbyId(keyword));
//		Mockito.when(userDaoMock.getUserbyId(keyword)).thenReturn(user);
//	}
//
//
////	@Test
////	public void searchUserForKeyword(){
////		Integer keyword = null;
////		String output = userService.searchUser(keyword);
////	    assertEquals(output, null);
////	}
//	
//	@Test
//	public void searchUserForKeywordWithRecord(){
//		Integer keyword = -1;
//		String output =  userService.searchUser(keyword);
//	    assertEquals(output ,null);
//	}
//
	@Test
	public void searchUserForKeywordWithNoRecord(){
		int keyword = 1;
		String output =   userService.searchUser(keyword);
		System.out.println("output======="+output);
		assertEquals(output ,"shashi");
	}
	
//	@Test
//	public void testing(){
//		int keyword = 2;
//		String output = "user not found";
//		 try {
//				User user = userService.getUserbyId(keyword);
//				output = user.getName();
//			} catch (Exception e) {	}
//		 
//		 assertEquals(output,"dipak");
//		 
//		
//	}
	
	
}
