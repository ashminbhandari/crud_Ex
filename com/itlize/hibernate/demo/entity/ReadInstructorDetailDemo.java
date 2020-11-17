package com.itlize.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadInstructorDetailDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

// create session
        Session session = factory.getCurrentSession();

        try {
// create a InstructorDetail object
            System.out.println("Creating instructor detail object...");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com/yangshu", "biking");

// start a transaction
            session.beginTransaction();

// save the InstructorDetail object
            System.out.println("Saving the InstructorDetail...");
            System.out.println(tempInstructorDetail);
            session.save(tempInstructorDetail);

// commit transaction
            session.getTransaction().commit();

// MY NEW CODE

// find out the InstructorDetail's id: primary key
            System.out.println("Saved InstructorDetail. Generated id: " + tempInstructorDetail.getId());

// now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

// retrieve InstructorDetail based on the id: primary key
            System.out.println("\nGetting InstructorDetail with id: " + tempInstructorDetail.getId());

            InstructorDetail myInstructorDetail = session.get(InstructorDetail.class, tempInstructorDetail.getId());

            System.out.println("Get complete: " + myInstructorDetail);

// commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}


