package com.solbeg.controller;


import com.solbeg.model.Student;
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
                var name = req.getParameter("name");
                var lastName = req.getParameter("lastName");
                var email = req.getParameter("email");
                var phone = req.getParameter("phone");
                StudentService service=new StudentService();
                service.saveStudent(name,lastName,email,phone,1L);
                resp.sendRedirect("/users");
            }
    }


