package com.dawn.origins.service.school_service;

import java.util.List;
import java.util.Optional;

import com.dawn.origins.database.entities.SchoolEntity;

public interface SchoolService {

    SchoolEntity createSchool(SchoolEntity school);

    Optional<SchoolEntity> getSchoolById(Long id);

    List<SchoolEntity> getAllSchools();

    SchoolEntity updateSchool(SchoolEntity school, Long id);

    void deleteSchool(Long id);

}
