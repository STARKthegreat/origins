package com.dawn.origins.service.student_service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawn.origins.database.entities.StudentEntity;
import com.dawn.origins.repository.StudentRepository;

@Service
public class ProdStudentService implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentEntity createStudent(StudentEntity newStudentEntity) {
        studentRepository.save(newStudentEntity);
        return newStudentEntity;
    }

    @Override
    public Optional<StudentEntity> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public StudentEntity updateStudent(StudentEntity newStudentEntity, Long id) {
        {
            StudentEntity oldStudentEntity = studentRepository.findById(id)
                    .get();

            if (Objects.nonNull(newStudentEntity.getName())
                    && !"".equalsIgnoreCase(
                            newStudentEntity.getName())) {
                oldStudentEntity.setName(
                        newStudentEntity.getName());
            }

            if (Objects.nonNull(
                    newStudentEntity.getFunFact())
                    && !"".equalsIgnoreCase(
                            newStudentEntity.getFunFact())) {
                oldStudentEntity.setFunFact(newStudentEntity.getFunFact());
                ;
            }

            if (Objects.nonNull(newStudentEntity.getSchool_id())
                    && !"".equals(
                            newStudentEntity.getSchool_id().toString())) {
                oldStudentEntity.setSchool_id(
                        newStudentEntity.getSchool_id());
            }

            return studentRepository.save(newStudentEntity);
        }
    }

    @Override
    public Boolean deleteStudent(Long id) {
        try {
            studentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return (List<StudentEntity>) studentRepository.findAll();
    }

}
