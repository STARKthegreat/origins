package com.dawn.origins.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawn.origins.database.entities.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {

}
