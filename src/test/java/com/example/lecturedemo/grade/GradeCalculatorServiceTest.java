package com.example.lecturedemo.grade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GradeCalculatorServiceTest {

	private final GradeCalculatorService gradeCalculatorService = new GradeCalculatorService();

	@Test
	void calculateGradeReturnsAForHighScore() {
		GradeResult result = gradeCalculatorService.calculateGrade(95);

		assertEquals("A", result.grade());
		assertEquals("Excellent", result.description());
	}

	@Test
	void calculateGradeReturnsCForMiddleScore() {
		GradeResult result = gradeCalculatorService.calculateGrade(75);

		assertEquals("C", result.grade());
		assertEquals("Average", result.description());
	}


}

