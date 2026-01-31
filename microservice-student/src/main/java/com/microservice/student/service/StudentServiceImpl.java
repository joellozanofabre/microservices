package com.microservice.student.service;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service    → Solo lógica de negocio
@Service
public class StudentServiceImpl implements IStudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();

    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {
        return studentRepository.findAllStudent(courseId);
    }

    @Override
    public void deleteById(Long courseId) {
        studentRepository.deleteById(courseId);
    }

}
