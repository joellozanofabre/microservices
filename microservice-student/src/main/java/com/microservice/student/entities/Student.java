package com.microservice.student.entities;

import jakarta.persistence.*;
import lombok.*;

//Anotaciones de Lombok (para reducir código boilerplate):
@Data            // Genera getters, setters, equals, hashCode y toString
@Builder         // Permite crear objetos con patrón Builder: Student.builder().name("Juan").build()
@AllArgsConstructor // Genera constructor con todos los argumentos
@NoArgsConstructor  // Genera constructor sin argumentos (requerido por JPA)
//Anotaciones de JPA (Jakarta Persistence):
@Entity          // Indica que esta clase es una entidad persistente (mapeada a tabla)
@Table(name="student") // Especifica el nombre de la tabla en la base de datos
public class Student {

    @Id  // Indica que este campo es la clave primaria
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 20)
    private String firstName;

    @Column(name = "last_name",length = 20)
    private String lastName;
    private String email;
    @Column(name = "course_id")
    private Long courseid;    // El campo courseid está relacionado con otro microservicio
}
