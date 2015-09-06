package com.nirvana.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private Date birthday;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}
	
	public User(Integer id, String username, String password, Date birthday) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", birthday=" + birthday + "]";
	}
}
