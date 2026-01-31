package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 * Por qué usar interfaces en Spring?
 * Desacoplamiento: Sigo el principio de inversión de dependencias (SOLID). Mi servicio depende de la abstracción StudentRepository,
 * no de StudentRepositoryJPAImpl. Esto permite cambiar la implementación sin modificar el servicio.
 * Testabilidad: Puedo crear mocks de la interfaz para pruebas unitarias. No necesito una base de datos real para probar mi lógica de negocio.
 * Spring Data JPA: Al extender JpaRepository, Spring me provee implementación automática de métodos CRUD y capacidad
 * de crear queries solo con la firma del método."
 * CrudRepository ahorra ~80% del código boilerplate.
 */
//Repository → Solo acceso a datos
@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    // Opción 1: Query Method (recomendado)
    //List<Student> findByCourseid(Long courseId);
    //List<Student> findAllByCourseId(Long courseId);


    // Opción 2: JPQL
    @Query("select s from Student s where s.courseid = :courseId")
    List<Student> findAllStudent(Long courseId);
}
