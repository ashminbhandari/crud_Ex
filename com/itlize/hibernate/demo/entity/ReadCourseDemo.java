package com.itlize.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itlize.hibernate.demo.entity.Course;

public class ReadCourseDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

// create session
        Session session = factory.getCurrentSession();

        try {
// create a Course object
            System.out.println("Creating instructor object...");
            Course tempCourse = new Course("History of Magic");

// start a transaction
            session.beginTransaction();

// save the Course object
            System.out.println("Saving the Course...");
            System.out.println(tempCourse);
            session.save(tempCourse);

// commit transaction
            session.getTransaction().commit();

// MY NEW CODE

// find out the Course's id: primary key
            System.out.println("Saved Course. Generated id: " + tempCourse.getId());

// now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

// retrieve Course based on the id: primary key
            System.out.println("\nGetting Course with id: " + tempCourse.getId());

            Course myCourse = session.get(Course.class, tempCourse.getId());

            System.out.println("Get complete: " + myCourse);

// commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}


