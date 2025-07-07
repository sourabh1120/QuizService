package com.example.quizController;

import java.util.List;

import com.example.dto.QuizDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Quiz;
import com.example.service.QuizService;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

	private final QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	@PostMapping
	public ResponseEntity<QuizDto> createQuiz(@RequestBody QuizDto quizDto) {
		return ResponseEntity.ok(quizService.add(quizDto));
	}

	@GetMapping()
	public ResponseEntity<List<QuizDto>> getAllQuizzes() {

		return ResponseEntity.ok(quizService.getAllQuiz());
	}

	@GetMapping("/{id}")
	public ResponseEntity<QuizDto> getQuizById(@PathVariable Long id) {
		return ResponseEntity.ok(quizService.getById(id));
	}

}
