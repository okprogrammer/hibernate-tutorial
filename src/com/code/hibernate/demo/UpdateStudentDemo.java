package com.code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {

			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id:primary key
			System.out.println("Getting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Updating student....: " + myStudent);
			myStudent.setFirstName("Scooby");
			// commit transaction
			session.getTransaction().commit();

			// NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			// update email for all students
			System.out.println("Update emial for all students");

			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// TODO: handle finally clause
		}

	}

}
