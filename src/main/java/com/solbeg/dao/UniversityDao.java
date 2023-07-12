//package com.solbeg.dao;
//
//import com.solbeg.model.University;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//public class UniversityDao {
//    private SessionFactory sessionFactory;
//
//    public UniversityDao(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public List<University> getAllUniversities() {
//        try (Session session = sessionFactory.openSession()) {
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<University> criteriaQuery = builder.createQuery(University.class);
//            Root<University> root = criteriaQuery.from(University.class);
//            criteriaQuery.select(root);
//            Query<University> query = session.createQuery(criteriaQuery);
//            return query.getResultList();
//        }
//    }
//
//    public University getUniversityById(Long id) {
//        try (Session session = sessionFactory.openSession()) {
//            return session.get(University.class, id);
//        }
//    }
//
//    public void saveUniversity(University university) {
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.saveOrUpdate(university);
//            transaction.commit();
//        }
//    }
//
//    public void deleteUniversity(University university) {
//        try (Session session = sessionFactory.openSession()) {
//            Transaction transaction = session.beginTransaction();
//            session.delete(university);
//            transaction.commit();
//        }
//    }
//}
//
