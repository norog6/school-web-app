package com.solbeg.controller;

import com.solbeg.model.Student;
import com.solbeg.model.University;
import com.solbeg.service.StudentService;
import com.solbeg.service.UniversityService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToLongBiFunction;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         UniversityService universityService=new UniversityService();
         University university=universityService.getUniversity(1L);
        req.setAttribute("university", university);
        req.getRequestDispatcher("/pages/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/main");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService service=new StudentService();
        service.deleteStudent(Long.parseLong(req.getParameter("id")));
    }
}
