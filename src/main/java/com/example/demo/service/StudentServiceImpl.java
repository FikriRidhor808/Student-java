package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.respository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(String idStudent) throws NoSuchFieldException {
        return studentRepository.findById(idStudent).orElseThrow(() -> {
            return new NoSuchFieldException("Student ndak ada");
        });
    }

    @Override
    public List<Student> getALLStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student editStudent(String idStudent, String name, String address) throws NoSuchFieldException {
        Student student = studentRepository.findById(idStudent).orElseThrow(() ->{
            return new NoSuchFieldException("Student ndak ada");
        });
        student.setName(name);
        student.setAddress(address);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String idStudent) {
        studentRepository.deleteById(idStudent);

    }

    @Override
    public List<Student> getAllStudent() {
        return null;
    }
}