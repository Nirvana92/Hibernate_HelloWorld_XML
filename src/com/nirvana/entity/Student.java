package com.nirvana.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	
	private Set<String> emailAddrs = new HashSet<String>();
	private Set<Teacher> teachers = new HashSet<Teacher>(); 
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Set<String> getEmailAddrs() {
		return emailAddrs;
	}

	public void setEmailAddrs(Set<String> emailAddrs) {
		this.emailAddrs = emailAddrs;
	}
	
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
