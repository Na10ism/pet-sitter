package com.nathanlesmann.capstone.petsitter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User", schema="Dog_Sitter")
public class User {
	
	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="user_first_name")
	private String user_first_name;
	
	@Column(name="user_last_name")
	private String user_last_name;
	
	@Column(name="user_pw")
	private String user_pw;
	
	@Column(name="user_name")
	private String user_name;
	
	
	// define constructors
	public User() {
		
	}


	public User(String user_first_name, String user_last_name, String user_pw, String user_name) {
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_pw = user_pw;
		this.user_name = user_name;
	}

	// define getter/setters

	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_first_name() {
		return user_first_name;
	}


	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}


	public String getUser_last_name() {
		return user_last_name;
	}


	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}


	public String getUser_pw() {
		return user_pw;
	}


	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	// define tostring
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_first_name=" + user_first_name + ", user_last_name="
				+ user_last_name + ", user_pw=" + user_pw + ", user_name=" + user_name + "]";
	};
	

	
	

	
}
