package com.lexitrace.model;

public class Word {

    private int id;
    private String word;
    private String translation;
    private String languagePair;

    public Word() {}

    public Word(int id, String word, String translation, String languagePair) {
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.languagePair = languagePair;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }

    public String getTranslation() { return translation; }
    public void setTranslation(String translation) { this.translation = translation; }

    public String getLanguagePair() { return languagePair; }
    public void setLanguagePair(String languagePair) { this.languagePair = languagePair; }
}
