package org.example;

// Clase Game modificada
public class Game {
    private IWordSelector wordSelector;
    private IHintGenerator hintGenerator;
    // Constructor con inyección de dependencias
    public Game(IWordSelector wordSelector, IHintGenerator hintGenerator) {
        this.wordSelector = wordSelector;
        this.hintGenerator = hintGenerator;
    }
    public void start() {
        if (wordSelector == null || hintGenerator == null) {
            throw new IllegalArgumentException("No estan los atributos");
        }
        String word = this.wordSelector.selectWord();
        String hint = this.hintGenerator.generateHint(word);
        System.out.println("Hint: " + hint);
    }
}