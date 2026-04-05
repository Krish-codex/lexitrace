package com.lexitrace.model;

public class Progress {

    private int userId;
    private int wordId;
    private int masteryLevel;
    private int correctCount;
    private int incorrectCount;

    public Progress(int userId, int wordId) {
        this.userId = userId;
        this.wordId = wordId;
        this.masteryLevel = 0;
    }

    public int getUserId() { return userId; }
    public int getWordId() { return wordId; }

    public int getMasteryLevel() { return masteryLevel; }
    public void setMasteryLevel(int masteryLevel) { this.masteryLevel = masteryLevel; }

    public int getCorrectCount() { return correctCount; }
    public void setCorrectCount(int correctCount) { this.correctCount = correctCount; }

    public int getIncorrectCount() { return incorrectCount; }
    public void setIncorrectCount(int incorrectCount) { this.incorrectCount = incorrectCount; }
}
