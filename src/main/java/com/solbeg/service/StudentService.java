package com.solbeg.service;

import com.solbeg.dao.StudentDao;
import com.solbeg.model.Student;
import com.solbeg.model.University;

public class StudentService {
    public void saveStudent(String name, String lastName, String email, String phone,Long id){
        StudentDao studentDao=new StudentDao();
        var student = Student.builder()
                .name(name)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .build();
        UniversityService service=new UniversityService();
        University university=service.getUniversity(id);
        university.addStudent(student);
        studentDao.saveStudent(student);
    }
    public void deleteStudent(Long id){
        StudentDao studentDao=new StudentDao();
        studentDao.deleteStudent(id);
    }


}
