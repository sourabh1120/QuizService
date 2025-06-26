package com.example.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Question;

@FeignClient(url = "http://localhost:8082", name = "questionClient")
public interface QuestionClient {

	@GetMapping("/api/v1/question/quiz/{quizId}") 
	List<Question> getQuestionByQuizId(@PathVariable("quizId") Long quizId);
	
	
}
