package com.microservice.student.service;

import com.microservice.student.entities.Student;

import java.util.List;

/***  El Problema con Clases Directas
 * Testing difícil: No puedes mockear fácilmente
 * Acoplamiento fuerte: Servicio depende de implementación específica
 * Cambios costosos: Cambiar de JPA a otro framework requiere reescribir todo
 * ----VENTAJAS----
 * Principio de Inversión de Dependencias (SOLID - D)   DIP: "Depende de abstracciones, no de implementaciones"
 * Facilidad de Testing (Mocking)
 * Cambio de Implementación sin Modificar Código
 */
public interface IStudentService {

    List<Student> findAll();
    Student findById(Long id);
    void save(Student student);
    List<Student> findByCourseId(Long courseId);
    void deleteById(Long id);

    //Student create(Student student);
    //Student update(Long id, Student student);
}
