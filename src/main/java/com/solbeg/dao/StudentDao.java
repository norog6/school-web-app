package com.solbeg.dao;

import com.solbeg.model.Student;
import com.solbeg.util.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;



public class StudentDao {
    public  void saveStudent(Student student) {
            @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();

    }
        public void deleteStudent(Long id){
            @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.remove(session.get(Student.class,id));
            session.getTransaction().commit();
        }

    }

