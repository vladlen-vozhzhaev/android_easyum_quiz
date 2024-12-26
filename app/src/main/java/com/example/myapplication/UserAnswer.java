package com.example.myapplication;

import java.io.Serializable;

public class UserAnswer implements Serializable {
    private int question;
    private boolean correctAnswer;
    private boolean userAnswer;

    public UserAnswer(int question, boolean correctAnswer, boolean userAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }
}
