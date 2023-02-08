package com.code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// create a student object
			System.out.println("Creating new Student object....");
			Student student = new Student("Daffu", "Duck", "daffy@gmail.com");
			// start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the student....");
			System.out.println(student);
			session.save(student);

			// commit transaction
			session.getTransaction().commit();

			// My NEW code
			// find the out student's id: primary key
			System.out.println("Saved student. Generated id:" + student.getId());
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id:primary key
			System.out.println("Getting student with id: " + student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println(myStudent);
			System.out.println("Done!");

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// TODO: handle finally clause
		}

	}

}
