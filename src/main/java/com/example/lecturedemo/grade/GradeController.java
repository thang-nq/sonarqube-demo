package com.example.lecturedemo.grade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeCalculatorService gradeCalculatorService;

    public GradeController(GradeCalculatorService gradeCalculatorService) {
        this.gradeCalculatorService = gradeCalculatorService;
    }

    @GetMapping("/{score}")
    public GradeResult getGrade(@PathVariable int score) {
        return gradeCalculatorService.calculateGrade(score);
    }
}

