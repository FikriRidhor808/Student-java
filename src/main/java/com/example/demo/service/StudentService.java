package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    Student getStudent(String idStudent) throws NoSuchFieldException;

    List<Student> getALLStudent();

    Student editStudent(String idStudent,String name, String address) throws  NoSuchFieldException;

    void deleteStudent(String idStudent);

    List<Student> getAllStudent();
}