package com.mystudy.service.impl;

import com.mystudy.dao.StudentDao;
import com.mystudy.entity.Student;
import com.mystudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    @Override
    public int addStudent(Student student) {
        int res = dao.insertStudent(student);
        return res;
    }

    @Override
    public List<Student> findStudents() {
        List<Student> list = dao.selectStudents();
        return list;
    }
}
