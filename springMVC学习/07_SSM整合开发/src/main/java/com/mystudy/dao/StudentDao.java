package com.mystudy.dao;

import com.mystudy.entity.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
