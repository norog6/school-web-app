package com.solbeg.controller;


import com.solbeg.model.Student;
import com.solbeg.model.University;
import com.solbeg.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/MainPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        University university=University.builder()
                .name("BSUIR")
                .id(1)
                .build();

                @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
                @Cleanup Session session = sessionFactory.openSession();
            session.beginTransaction();
                var name = req.getParameter("name");
                var lastName = req.getParameter("lastName");
                var email = req.getParameter("email");
                var phone = req.getParameter("phone");
        //  University university1=session.get(University.class,university
          //              .getName());
            //    university.setId(university1.getId());
                var student = Student.builder()
                        .name(name)
                        .lastName(lastName)
                        .email(email)
                        .phone(phone)
                        .university(university)
                        .build();


                session.saveOrUpdate(student);

                session.getTransaction().commit();
            }

    }


