package com.userapp.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.userapp.model.User;

@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

	@Query(value = "select * from user u where u.user_id=?1", nativeQuery = true)
	User getUserbyId(int id);
	
	@Query(value = "select * from user u where u.user_id=? && u.user_pswrd=?", nativeQuery = true)
	Optional<User> findByIdPswrd(int id , String password);
	
	@Query(value = "select * from user u where u.user_id=?1", nativeQuery = true)
	User getUserbyId2(int id);
	
	@Query(value = "select * from user u where u.user_id=?1", nativeQuery = true)
	User getUserbyId3(int id);
	
	@Query(value = "select * from user u where u.user_id=?1", nativeQuery = true)
	User getUserbyId4(int id);
	
	@Query(value = "select * from user u where u.user_id=?1", nativeQuery = true)
	User getUserbyId5(int id);
	
}
