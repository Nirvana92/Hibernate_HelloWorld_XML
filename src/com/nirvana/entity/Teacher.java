package com.nirvana.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private Integer id;
	private String name;
	private Integer age;
	
	private Set<Student> students = new HashSet<Student>();
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher(String name, Integer age, Set<Student> students) {
		super();
		this.name = name;
		this.age = age;
		this.students = students;
	}

	public Teacher(Integer id, String name, Integer age, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.students = students;
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

	protected Set<Student> getStudents() {
		return students;
	}

	protected void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	//m-to-m
	public void addToStudents(Student s) {
		this.getStudents().add(s);
		s.getTeachers().add(this);
	}
	
	//m-to-m
	public void removeFromStudents(Student s) {
		this.getStudents().remove(s);
		s.getTeachers().remove(this);
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age
				+ ", students=" + students + "]";
	}
}
