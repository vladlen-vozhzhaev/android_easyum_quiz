package com.example.myapplication;

public class Question {
    private int question;
    private boolean correctAnswer;

    public Question(int question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }
}