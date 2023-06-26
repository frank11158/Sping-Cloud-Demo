package com.example.students.service;

import com.example.students.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void createStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);
}
