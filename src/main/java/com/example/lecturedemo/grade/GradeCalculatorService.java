package com.example.lecturedemo.grade;

import org.springframework.stereotype.Service;

@Service
public class GradeCalculatorService {

    public GradeResult calculateGrade(int score) {
        validateScore(score);

        String grade = toLetterGrade(score);
        String description = toDescription(grade);
        return new GradeResult(score, grade, description);
    }

    private String toLetterGrade(int score) {
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        if (score >= 60) {
            return "D";
        }
        return "F";
    }

    private String toDescription(String grade) {
        return switch (grade) {
            case "A" -> "Excellent";
            case "B" -> "Good";
            case "C" -> "Average";
            case "D" -> "Below Average";
            default -> "Needs Improvement";
        };
    }

    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }
}

