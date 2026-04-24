package com.example.lecturedemo.grade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GradeCalculatorServiceTest {

	private final GradeCalculatorService gradeCalculatorService = new GradeCalculatorService();

	@Test
	void calculateGradeReturnsAForHighScore() {
		GradeResult result = gradeCalculatorService.calculateGrade(95);

		assertEquals("A1", result.grade());
		assertEquals("Excellent", result.description());
	}

	@Test
	void calculateGradeReturnsCForMiddleScore() {
		GradeResult result = gradeCalculatorService.calculateGrade(75);

		assertEquals("C", result.grade());
		assertEquals("Average", result.description());
	}

	@Test
	void calculateGradeReturnsFFailingScore() {
		GradeResult result = gradeCalculatorService.calculateGrade(52);

		assertEquals("F", result.grade());
		assertEquals("Needs Improvement", result.description());
	}

	@Test
	void calculateGradeThrowsWhenScoreIsNegative() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> gradeCalculatorService.calculateGrade(-1));

		assertEquals("Score must be between 0 and 100", exception.getMessage());
	}

	@Test
	void calculateGradeThrowsWhenScoreIsTooLarge() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> gradeCalculatorService.calculateGrade(101));

		assertEquals("Score must be between 0 and 100", exception.getMessage());
	}

}

