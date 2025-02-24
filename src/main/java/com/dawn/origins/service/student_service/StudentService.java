package com.dawn.origins.service.student_service;

import java.util.List;
import java.util.Optional;

import com.dawn.origins.database.entities.StudentEntity;

public interface StudentService {

    StudentEntity createStudent(StudentEntity student);

    Optional<StudentEntity> getStudentById(Long id);

    StudentEntity updateStudent(StudentEntity student, Long id);

    Boolean deleteStudent(Long id);

    List<StudentEntity> getAllStudents();

}
