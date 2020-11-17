package com.itlize.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateInstructorDetailDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int InstructorDetailId = 19;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve InstructorDetail based on the id: primary key
            System.out.println("\nGetting InstructorDetail with id: " + InstructorDetailId);

            InstructorDetail myInstructorDetail = session.get(InstructorDetail.class, InstructorDetailId);

            System.out.println("Updating InstructorDetail...");
            myInstructorDetail.setYoutubeChannel("yotube.com/efee");

            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update hobby for all InstructorDetails
            System.out.println("Update hobby for all InstructorDetails");

            session.createQuery("update InstructorDetail set hobby='hiking'")
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
