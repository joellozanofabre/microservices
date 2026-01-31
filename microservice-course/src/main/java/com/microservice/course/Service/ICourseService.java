package com.microservice.course.Service;


import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudenByCourseResponse;

import java.util.List;

public interface ICourseService {

    Course findById(Long id);
    List<Course> findAll();
    void save(Course course);

    StudenByCourseResponse findStudentByIdCourse(Long idCourse);
}
