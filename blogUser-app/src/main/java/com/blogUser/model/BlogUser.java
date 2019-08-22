package com.blogUser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blog_user")
public class BlogUser {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@Column(name = "user_code")
	private String user_code;

	@Column(name = "user_email")
	private String user_email;

	@Column(name = "user_password")
	private String user_password;
	
	@Column(name = "user_isnewsletterapplied")
	private String user_isnewsletterapplied;
	
	@Column(name = "user_browser_info")
	private String user_browser_info;
	
	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_code() {
		return user_code;
	}
	
	public void setName(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_isnewsletterapplied() {
		return user_isnewsletterapplied;
	}

	public void setUser_isnewsletterapplied(String user_isnewsletterapplied) {
		this.user_isnewsletterapplied = user_isnewsletterapplied;
	}
	
	public String getUser_browser_info() {
		return user_browser_info;
	}

	public void setUser_browser_info(String user_browser_info) {
		this.user_browser_info = user_browser_info;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + user_id + ", code=" + user_code + ", email=" + user_email + ", "
				+ "NewsLetterApplied=" + user_isnewsletterapplied +  "user_pswrd=" + user_password + "]";
	}

}
