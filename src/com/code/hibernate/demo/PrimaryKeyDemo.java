package com.code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create 3 student object
			System.out.println("Creating 3 new Student object....");
			Student student1 = new Student("Paul", "Wall", "paul@gmail.com");
			Student student2 = new Student("Max", "Blink", "max@gmail.com");
			Student student3 = new Student("Raymond", "Murphy", "raymond@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the students....");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// TODO: handle finally clause
		}

	}

}
