package org.example;

public class DependencyInjector {
    public static IHintGenerator hintGenerator(String wordToGuess) {
        return new HintGenerator(wordToGuess);
    }
    public static IWordSelector wordSelector(String[] possibleWords) {
        return new WordSelector(possibleWords);
    }
}