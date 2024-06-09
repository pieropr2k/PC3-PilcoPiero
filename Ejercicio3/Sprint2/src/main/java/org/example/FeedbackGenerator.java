package org.example;

public class FeedbackGenerator implements IFeedbackGenerator{
    private String wordToGuess;

    public FeedbackGenerator(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public String generateFeedback(String tryWord) {
        int correctChars = 0;
        char[] tryWordArray = tryWord.toCharArray();
        char[] wordToGuessArray = wordToGuess.toCharArray();
        int loopLength = Math.min(tryWord.length(), wordToGuess.length());

        for (int i = 0; i < loopLength; i++) {
            if (wordToGuessArray[i] == tryWordArray[i]) {
                correctChars++;
            }
        }
        return "La palabra tiene "+ correctChars +" letras correctas en la posición correcta";
    }
}
