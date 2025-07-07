package com.example.dto;

import java.util.List;

public class QuizDto {

    private Long id;
    private String title;
    private List<QuestionDto> questions;

    public QuizDto(){

    }

    public QuizDto(Long id, String title, List<QuestionDto> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
