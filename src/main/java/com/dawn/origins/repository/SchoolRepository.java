package com.dawn.origins.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawn.origins.database.entities.SchoolEntity;

// Annotation
@Repository

// Interface extending CrudRepository
public interface SchoolRepository
        extends CrudRepository<SchoolEntity, Long> {
}
