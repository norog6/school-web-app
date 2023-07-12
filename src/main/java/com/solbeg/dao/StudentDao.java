package com.solbeg.dao;
import com.solbeg.model.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class StudentDao {
    public static void saveStudent(Student student) {
        Configuration configuration = new Configuration();

        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

