package com.example.quizController;

import java.util.List;

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

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	@PostMapping("/addQuiz")
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}

	@GetMapping("/allQuiz")
	public List<Quiz> getAllQuiz() {
		return quizService.getAllQuiz();
	}

	@GetMapping("/{quizId}")
	public Quiz getQuizById(@PathVariable Long quizId) {
		return quizService.getById(quizId);
	}

}
