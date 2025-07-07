package com.example.service;

import java.util.List;

import com.example.dto.QuizDto;

public interface QuizService {
	QuizDto add(QuizDto quizDto);
	List<QuizDto> getAllQuiz();
	QuizDto getById(Long id);
}
