package com.dawn.origins.database.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Column(nullable = false)
    String name;
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Schema(hidden = true)
    Long id;
    @Column(nullable = false)
    Integer school_id;
    @Column(nullable = false)
    String funFact;

    public StudentEntity() {
    }

    public StudentEntity(String name, Integer class_id, Integer school_id, String funFact) {
        this.name = name;
        this.school_id = school_id;
        this.funFact = funFact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

}
