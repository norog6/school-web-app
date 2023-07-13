package com.solbeg.controller;


import com.solbeg.model.Student;
import com.solbeg.model.University;
import com.solbeg.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        University university=University.builder()
                .name("BSUIR")
                .id(1L)
                .build();
                var name = req.getParameter("name");
                var lastName = req.getParameter("lastName");
                var email = req.getParameter("email");
                var phone = req.getParameter("phone");
                var student = Student.builder()
                        .name(name)
                        .lastName(lastName)
                        .email(email)
                        .phone(phone)
                        .build();
                university.addStudent(student);
                StudentService service=new StudentService();
                service.saveStudent(student);
                resp.sendRedirect("/users");

            }

    }


