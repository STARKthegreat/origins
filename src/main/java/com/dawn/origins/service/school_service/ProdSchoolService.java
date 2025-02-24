package com.dawn.origins.service.school_service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawn.origins.database.entities.SchoolEntity;
import com.dawn.origins.repository.SchoolRepository;

@Service
public class ProdSchoolService implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public SchoolEntity createSchool(SchoolEntity school) {
        return schoolRepository.save(school);
    }

    @Override
    public Optional<SchoolEntity> getSchoolById(Long id) {
        return schoolRepository.findById(id);

    }

    @Override
    public List<SchoolEntity> getAllSchools() {
        return (List<SchoolEntity>) schoolRepository.findAll();
    }

    @Override
    public SchoolEntity updateSchool(SchoolEntity newSchoolEntity, Long id) {

        SchoolEntity oldSchoolEntity = schoolRepository.findById(id).get();

        if (newSchoolEntity.getName() != null && !"".equalsIgnoreCase(newSchoolEntity.getName())) {
            oldSchoolEntity.setName(newSchoolEntity.getName());
        }

        if (newSchoolEntity.getAddress() != null && !"".equalsIgnoreCase(newSchoolEntity.getAddress())) {
            oldSchoolEntity.setAddress(newSchoolEntity.getAddress());
        }

        if (newSchoolEntity.getNumberOfStudents() != null
                && !"".equals(newSchoolEntity.getNumberOfStudents().toString())) {
            oldSchoolEntity.setNumberOfStudents(newSchoolEntity.getNumberOfStudents());
        }

        if (newSchoolEntity.getClasses() != null && !"".equalsIgnoreCase(newSchoolEntity.getClasses())) {
            oldSchoolEntity.setClasses(newSchoolEntity.getClasses());
        }

        return schoolRepository.save(oldSchoolEntity);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

}
