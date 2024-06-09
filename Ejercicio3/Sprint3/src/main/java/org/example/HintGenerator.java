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
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (i >= tryWord.length() || wordToGuessArray[i] != tryWordArray[i]) {
                hint += "_";
            } else {
                hint += wordToGuessArray[i];
            }
        }

        return hint;
    }

    public String getSpecialHint(){
        return "Termina con " + wordToGuess.charAt(wordToGuess.length()-1);
    }
}