package com.nirvana.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nirvana.entity.Student;
import com.nirvana.entity.Teacher;
import com.nirvana.entity.User;
import com.nirvana.util.HibernateUtil;

public class HibernateManager {
	public static void main(String[] args) {
		//new HibernateManager().insert();
		//List<User> users = new HibernateManager().listUsers();
		//new HibernateManager().initStuAndTea();
		//new HibernateManager().initStu();
		//new HibernateManager().mtmLoad();
		new HibernateManager().addStuToTea();
		//new HibernateManager().addStuToTea2();
		//new HibernateManager().addEmailToStu();
	}
	
	private void addEmailToStu() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Student s = (Student) session.load(Student.class, 2);
		s.getEmailAddrs().add("spring@163.com");
		
		session.getTransaction().commit();
	}
	
	//while the object is detached
	private void addStuToTea() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Teacher t = (Teacher) session.createQuery("select t from Teacher t left join fetch t.students where t.id=:tid")
			.setParameter("tid", 1)
			.uniqueResult();// Eager fetch the collection so we can use it detached
		
		/*** 问题 ****/
		//注释掉上面的获取teacher方法  使用下面方法  报错:
		//Exception in thread "main" org.hibernate.LazyInitializationException: could not initialize proxy - no Session
		//Teacher t = (Teacher) session.load(Teacher.class, 1);
		Student s = (Student) session.load(Student.class, 2);
		
		session.getTransaction().commit();
		t.addToStudents(s);
		//t.getStudents().add(s);
		
		Session s1 = HibernateUtil.getSessionFactory().getCurrentSession();
		s1.beginTransaction();
		s1.update(t);
		s1.getTransaction().commit();
	}
	
	//通过load方式获取teacher
	private void addStuToTea2() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Teacher t = (Teacher) session.load(Teacher.class, 1);
		Student s = (Student) session.load(Student.class, 3);
		
		//持久化状态->游离状态
		session.close();
		t.addToStudents(s);
		//t.getStudents().add(s);
		Session s1 = HibernateUtil.getSessionFactory().getCurrentSession();
		s1.beginTransaction();
		s1.update(t);
		s1.getTransaction().commit();
	}
	
	//mang-to-mang
	private void mtmLoad() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Student s = (Student) session.load(Student.class, 1);
		Teacher t = (Teacher) session.load(Teacher.class, 1);
		
		t.addToStudents(s);
		//t.getStudents().add(s);
		session.getTransaction().commit();
	}
	
	private void initStu() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Student s = new Student("Spring", 25);
		
		session.save(s);
		session.getTransaction().commit();
	}
	
	private void initStuAndTea() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Student s = new Student("Nirvana", 24);
		Teacher t = new Teacher("Mrs tom", 30);
		
		session.save(s);
		session.save(t);
		session.getTransaction().commit();
	}
	
	//插入数据
	private void insert() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date bir = null;
		try {
			bir = sdf.parse("1992-10-13 12:12:12");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User u = new User("Nirvana", "jinlei520", bir);
		createAndStoreUser(u);
	}
	
	private void createAndStoreUser(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(u);
		
		session.getTransaction().commit();
	}
	
	//查找数据集合
	private List<User> listUsers() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		List<User> users = session.createQuery("from User").list();
		session.getTransaction().commit();
		return users;
	}
}
