package org.example;

import java.util.List;

// Implementación WordSelector
public class WordSelector implements IWordSelector {
    private final String[] possibleWords;
    private final int selectedWordIndex;

    public WordSelector (String[] possibleWords, int selectedWordIndex) {
        this.possibleWords = possibleWords;
        this.selectedWordIndex = selectedWordIndex;
    }
    public String selectWord() {
        return this.possibleWords[this.selectedWordIndex-1];
    }
}