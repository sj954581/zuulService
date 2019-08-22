package com.blogUser.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.blogUser.model.BlogUser;

@Transactional
public interface BlogUserDao extends CrudRepository<BlogUser, Integer> {

	@Query(value = "select * from blog_user bu where bu.user_id=?1", nativeQuery = true)
	BlogUserDao getBlogUserbyId(int id);

	@Query(value = "select * from blog_user bu where bu.user_id=?1", nativeQuery = true)
	BlogUserDao getBlogUserbyId1(int id);

	@Query(value = "select * from blog_user bu where bu.user_id=?1", nativeQuery = true)
	BlogUserDao getBlogUserbyId2(int id);
	
	@Query(value = "select * from blog_user bu where bu.user_id=?1", nativeQuery = true)
	BlogUserDao getBlogUserbyId3(int id);
}
