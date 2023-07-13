package com.solbeg.dao;

import com.solbeg.model.University;
import com.solbeg.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UniversityDao {
    public University getUniversity(Long id){
        @Cleanup Session session = HibernateUtil.getSessionFactory().openSession();
return session.createQuery("from University u left join fetch u.students", University.class).getSingleResultOrNull();
    }
}

