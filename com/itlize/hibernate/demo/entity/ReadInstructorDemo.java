package com.itlize.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itlize.hibernate.demo.entity.Student;

public class ReadInstructorDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

// create session
        Session session = factory.getCurrentSession();

        try {
// create a Instructor object
            System.out.println("Creating instructor object...");
            Instructor tempInstructor = new Instructor("jing", "wang", "jing@gmail.com");

// start a transaction
            session.beginTransaction();

// save the Instructor object
            System.out.println("Saving the Instructor...");
            System.out.println(tempInstructor);
            session.save(tempInstructor);

// commit transaction
            session.getTransaction().commit();

// MY NEW CODE

// find out the Instructor's id: primary key
            System.out.println("Saved Instructor. Generated id: " + tempInstructor.getId());

// now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

// retrieve Instructor based on the id: primary key
            System.out.println("\nGetting Instructor with id: " + tempInstructor.getId());

            Instructor myInstructor = session.get(Instructor.class, tempInstructor.getId());

            System.out.println("Get complete: " + myInstructor);

// commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}


