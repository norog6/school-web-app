package com.solbeg.service;

import com.solbeg.dao.StudentDao;
import com.solbeg.model.Student;

public class StudentService {
    public void saveStudent(Student student){
        StudentDao studentDao=new StudentDao();
        studentDao.saveStudent(student);
    }
    public void deleteStudent(Long id){
        StudentDao studentDao=new StudentDao();
        studentDao.deleteStudent(id);
    }
}
