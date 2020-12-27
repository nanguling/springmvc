package com.mystudy.service;

import com.mystudy.entity.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> findStudents();
}
