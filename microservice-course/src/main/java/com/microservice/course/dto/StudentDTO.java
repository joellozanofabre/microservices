package com.microservice.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String firstName;
    private String lastName;
    private String email;
    private Long courseid;

}
