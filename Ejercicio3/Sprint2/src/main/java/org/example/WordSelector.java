package org.example;

import java.util.List;

// Implementación WordSelector
public class WordSelector implements IWordSelector {
    private final String[] possibleWords;

    public WordSelector(String[] possibleWords) {
        this.possibleWords = possibleWords;
    }
    public String selectWord(int selectedWordIndex) {
        if (selectedWordIndex <= 0 || selectedWordIndex > possibleWords.length) {
            throw new IllegalArgumentException("");
        }
        return this.possibleWords[selectedWordIndex-1];
    }
}