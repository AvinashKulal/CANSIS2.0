package com.example.cansis20;

public class CalculatorGetterSetter {
    private String subject;
    private int creditScore;

    public CalculatorGetterSetter(String subject, int creditScore) {
        this.subject = subject;
        this.creditScore = creditScore;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getSubject() {
        return subject;
    }

    public int getCreditScore() {
        return creditScore;
    }
}
