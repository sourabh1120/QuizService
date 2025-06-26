package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.entity.Quiz;
import com.example.repository.QuizRepository;
import com.example.service.QuestionClient;
import com.example.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	private QuizRepository quizRepository;
	private QuestionClient questionClient;

	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		List<Quiz> quizzes = quizRepository.findAll();
		return quizzes.stream()
			    .map(quiz -> { 
			        quiz.setQuestions(questionClient.getQuestionByQuizId(quiz.getId()));
			        return quiz;
			    }).collect(Collectors.toList());
	}

	@Override
	public Quiz getById(Long id) {
		Quiz quiz= quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz Not Found"));
		quiz.setQuestions(questionClient.getQuestionByQuizId(quiz.getId()));
		return quiz;
	}
}
