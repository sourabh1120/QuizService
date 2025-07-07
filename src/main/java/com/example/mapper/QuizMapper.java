package com.example.mapper;

import com.example.dto.QuizDto;
import com.example.entity.Quiz;

public class QuizMapper {

    public static QuizDto toDto(Quiz quiz) {
        QuizDto dto = new QuizDto();
        dto.setId(quiz.getId());
        dto.setTitle(quiz.getTitle());
        return dto;
    }

    public static Quiz toEntity(QuizDto dto) {
        Quiz quiz = new Quiz();
        quiz.setId(dto.getId());
        quiz.setTitle(dto.getTitle());
        return quiz;
    }
}
