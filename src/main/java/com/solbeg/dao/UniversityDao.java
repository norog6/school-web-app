package com.solbeg.dao;

import com.solbeg.model.University;
import com.solbeg.util.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;

public class UniversityDao {
    public University getUniversity(Long id){
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
return session.createQuery("from University u left join fetch u.students", University.class).getSingleResultOrNull();
    }
}

