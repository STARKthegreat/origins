package com.dawn.origins.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dawn.origins.database.entities.StudentEntity;
import com.dawn.origins.model.ApiError;
import com.dawn.origins.service.student_service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/school")
@CrossOrigin(origins = "*")
public class SchoolController {

    private StudentService studentService;

    public SchoolController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get all students", description = "Returns all students or an empty list")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = StudentEntity.class)))
    @GetMapping("/students")
    public ResponseEntity<?> getMethodName() {
        try {
            return ResponseEntity.ok().body(studentService.getAllStudents());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(
                    e.getLocalizedMessage(),
                    "Students not found",
                    HttpStatus.NOT_FOUND.value(),
                    String.valueOf(System.currentTimeMillis())

            ));
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = StudentEntity.class))),
            @ApiResponse(responseCode = "404", description = "Student not created", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @PostMapping("/student")
    public ResponseEntity<?> postMethodName(@RequestBody StudentEntity entity) {
        try {
            return ResponseEntity.ok().body(studentService.createStudent(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(
                    e.getLocalizedMessage(),
                    "Student not created",
                    HttpStatus.NOT_FOUND.value(),
                    String.valueOf(System.currentTimeMillis())

            ));
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = StudentEntity.class))),
            @ApiResponse(responseCode = "404", description = "Student not found", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @PutMapping("students/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable String id, @RequestBody StudentEntity entity) {
        try {
            return ResponseEntity.ok().body(studentService.updateStudent(entity, Long.parseLong(id)));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(
                    e.getLocalizedMessage(),
                    "Student not found",
                    HttpStatus.NOT_FOUND.value(),
                    String.valueOf(System.currentTimeMillis())));
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "404", description = "Student not found", content = @Content(schema = @Schema(implementation = ApiError.class)))
    })
    @DeleteMapping("student/{id}")
    public ResponseEntity<?> deleteMethodName(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(
                    new ApiError(
                            "Student deleted",
                            "Student deleted successfully",
                            HttpStatus.OK.value(),
                            String.valueOf(System.currentTimeMillis())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(
                    e.getLocalizedMessage(),
                    "Student not found",
                    HttpStatus.NOT_FOUND.value(),
                    String.valueOf(System.currentTimeMillis())

            ));
        }

    }

    @GetMapping("/ping")
    public String getMistake() {
        return "I didn't update my profile picture";
    }

}
