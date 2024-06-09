package org.example;

// Implementación HintGenerator
public class HintGenerator implements IHintGenerator {
    String wordToGuess;

    public HintGenerator(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String generateHint(String tryWord) {
        String hint = "";
        char[] tryWordArray = tryWord.toCharArray();
        char[] wordToGuessArray = wordToGuess.toCharArray();
        int loopLength = Math.min(tryWord.length(), wordToGuess.length());

        for (int i = 0; i < loopLength; i++) {
            if (wordToGuessArray[i] == tryWordArray[i]) {
                hint += wordToGuessArray[i];
            } else {
                hint += "_";
            }
        }
        return hint;
    }
}