package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.dto.QuestionDto;
import com.example.dto.QuizDto;
import com.example.exception.ResourceNotFoundException;
import com.example.mapper.QuizMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.Quiz;
import com.example.repository.QuizRepository;
import com.example.service.QuestionClient;
import com.example.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{


	private final QuizRepository quizRepository;
	private final QuestionClient questionClient;

	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Cacheable(value = "QuestionsByQuiz", key = "#quizId")
	public List<QuestionDto> getCachedQuestionsByQuizId(Long quizId) {

		return questionClient.getQuestionByQuizId(quizId);
	}

	@Override
	public QuizDto add(QuizDto quizDto) {
		Quiz saved = quizRepository.save(QuizMapper.toEntity(quizDto));
		QuizDto dto = QuizMapper.toDto(saved);
		dto.setQuestions(getCachedQuestionsByQuizId(saved.getId()));
		return dto;
	}

	@Override
	public List<QuizDto> getAllQuiz() {
		return quizRepository.findAll().stream().map(quiz -> {
			QuizDto dto = QuizMapper.toDto(quiz);
			dto.setQuestions(getCachedQuestionsByQuizId(quiz.getId()));
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public QuizDto getById(Long id) {
		Quiz quiz = quizRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: " + id));
		QuizDto dto = QuizMapper.toDto(quiz);
		dto.setQuestions(getCachedQuestionsByQuizId(id));
		return dto;
	}
}
