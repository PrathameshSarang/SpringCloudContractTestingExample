package com.afourtech.consumer;

public class ConsumerResponse {
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    private Grade grade;

    public ConsumerResponse(Grade  grade) {
        this.grade = grade;
    }

    public enum Grade{
        O,A,B
    }
}
