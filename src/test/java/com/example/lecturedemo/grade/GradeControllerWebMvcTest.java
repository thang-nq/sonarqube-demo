package com.example.lecturedemo.grade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class GradeControllerWebMvcTest {

	@Mock
	private GradeCalculatorService gradeCalculatorService;

	private MockMvc createMockMvc() {
		return MockMvcBuilders.standaloneSetup(new GradeController(gradeCalculatorService))
				.setControllerAdvice(new ApiExceptionHandler())
				.build();
	}

	@Test
	void getGradeReturnsResult() throws Exception {
		MockMvc mockMvc = createMockMvc();

		when(gradeCalculatorService.calculateGrade(88))
				.thenReturn(new GradeResult(88, "B", "Good"));

		mockMvc.perform(get("/api/grades/88"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.score").value(88))
				.andExpect(jsonPath("$.grade").value("B"))
				.andExpect(jsonPath("$.description").value("Good"));
	}

	@Test
	void getGradeReturnsBadRequestForInvalidScore() throws Exception {
		MockMvc mockMvc = createMockMvc();

		when(gradeCalculatorService.calculateGrade(120))
				.thenThrow(new IllegalArgumentException("Score must be between 0 and 100"));

		mockMvc.perform(get("/api/grades/120"))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.title").value("Invalid input"))
				.andExpect(jsonPath("$.detail").value("Score must be between 0 and 100"));
	}
}


