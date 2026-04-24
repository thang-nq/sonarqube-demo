package com.example.lecturedemo.grade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeCalculatorServiceTest {

	private final GradeCalculatorService gradeCalculatorService = new GradeCalculatorService();

	@Test
	void calculateGradeReturnsAForHighScore() {
		GradeResult result = gradeCalculatorService.calculateGrade(95);

		assertEquals("A", result.grade());
		assertEquals("Excellent", result.description());
	}

}

