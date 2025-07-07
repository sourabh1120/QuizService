package com.example.service;

import java.util.List;

import com.example.dto.QuestionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Question;

//@FeignClient(name = "question-service", url = "http://localhost:8082")
@FeignClient(name = "questionservice")
public interface QuestionClient {

	@GetMapping("/api/v1/question/quiz/{quizId}")
	List<QuestionDto> getQuestionByQuizId(@PathVariable("quizId") Long quizId);
}
