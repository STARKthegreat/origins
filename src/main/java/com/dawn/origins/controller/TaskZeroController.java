package com.dawn.origins.controller;

import java.time.OffsetDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawn.origins.model.TaskZero;

@RestController
public class TaskZeroController {

    @GetMapping("/task0")
    public TaskZero taskZero() {
        return new TaskZero(
                "EmmanuelKipropKimutai@gmail.com",
                OffsetDateTime.now().toInstant(),
                "https://github.com/STARKthegreat/origins/");
    }
}
