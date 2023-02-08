package com.code.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.code.hibernate.demo.entity.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();
			// query students
			List<Student> students = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(students);

			// query students: lastName='Wall'
			System.out.println("query students: lastName='Wall'");
			students = session.createQuery("from Student s where s.lastName='Wall'").getResultList();

			// display the students
			displayStudents(students);

			// query students: lastName='Doe' OR firstName='Daffy'
			students = session.createQuery("from Student s where" + " s.lastName='Wall' OR s.firstName='Max'")
					.getResultList();
			System.out.println("**Students who have last name of Doe OR first name Paul**");
			displayStudents(students);
			// query students where email LIKE '%gmail.com%'
			System.out.println("##query students where email LIKE '%gmail.com%' ##");
			students = session.createQuery("from Student s where" + " s.email LIKE '%gmail.com%'").getResultList();
			displayStudents(students);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// TODO: handle finally clause
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
