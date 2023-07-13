package com.solbeg.service;

import com.solbeg.dao.UniversityDao;
import com.solbeg.model.University;

public class UniversityService {
    public University getUniversity(Long id){
        UniversityDao universityDao=new UniversityDao();
        return universityDao.getUniversity(id);
    }
}
