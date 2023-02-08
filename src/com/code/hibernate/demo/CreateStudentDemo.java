package com.code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create a student object
			System.out.println("Creating new Student object....");
			Student student = new Student("Paul", "Wall", "paul@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student....");
			session.save(student);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// TODO: handle finally clause
		}

	}

}
