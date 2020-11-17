package com.itlize.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateInstructorDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int InstructorId = 19;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve Instructor based on the id: primary key
            System.out.println("\nGetting Instructor with id: " + InstructorId);

            Instructor myInstructor = session.get(Instructor.class, InstructorId);

            System.out.println("Updating Instructor...");
            myInstructor.setFirstName("Hello");

            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all Instructors
            System.out.println("Update email for all Instructors");

            session.createQuery("update Instructor set email='changeEmail@itlize.com'")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
