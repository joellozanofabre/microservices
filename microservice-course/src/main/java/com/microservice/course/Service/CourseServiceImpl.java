package com.microservice.course.Service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudenByCourseResponse;
import com.microservice.course.infrastructure.ICourseRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private StudentClient studentClient;

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudenByCourseResponse findStudentByIdCourse(Long idCourse) {
        try {
            //consultar el curso
            Course course = courseRepository.findById(idCourse).orElseThrow();
            ;

            //obtener los studiantes
            List<StudentDTO> studentDTOlist = studentClient.findAllStudentByCourse(course.getId());
            return StudenByCourseResponse.builder()
                    .courseName(course.getName())
                    .teacherName(course.getTeacher())
                    .studentDTOList(studentDTOlist)
                    .build();
        } catch (FeignException.NotFound e) {
            // Manejar específicamente error 404
            throw new RuntimeException("Servicio de estudiantes no disponible o endpoint no encontrado", e);
        } catch (FeignException e) {
            // Otros errores de Feign
            throw new RuntimeException("Error al comunicarse con el servicio de estudiantes", e);
        }
    }
}