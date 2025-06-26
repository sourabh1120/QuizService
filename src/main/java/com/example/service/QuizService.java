package com.example.service;

import java.util.List;

import com.example.entity.Quiz;

public interface QuizService {

	public Quiz add(Quiz quiz); 
	public List<Quiz> getAllQuiz();
	public Quiz getById(Long id);
	
}
