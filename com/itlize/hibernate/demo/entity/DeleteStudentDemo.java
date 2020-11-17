package com.itlize.hibernate.demo.entity;


	
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

	import com.itlize.hibernate.demo.entity.Student;

	public class DeleteStudentDemo {

		public static void main(String[] args) {

			// create session factory
			SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
			
			// create session
			Session session = factory.getCurrentSession();
			
			try {								
				int studentId = 17;
				
				// now get a new session and start transaction
				session = factory.getCurrentSession();
				session.beginTransaction();
				
				// retrieve student based on the id: primary key
				System.out.println("\nGetting student with id: " + studentId);
				
				Student myStudent = session.get(Student.class, studentId);
				
				// delete the student
				// System.out.println("Deleting student: " + myStudent);
				// session.delete(myStudent);
				
				// delete student id=18
				System.out.println("Deleting student id=17");
				
				session.createQuery("delete from Student where id=17").executeUpdate();
				
				// commit the transaction
				session.getTransaction().commit();
				
				System.out.println("Done!");
			}
			finally {
				factory.close();
			}
		}

	}








