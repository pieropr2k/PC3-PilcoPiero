package org.example;

public class Main {
    public static void main(String[] args) {
        String[] possibleWordsList = new String[]{"example", "campeon", "maraton", "futbol"};
        int selectedWordIndex = 1;
        IWordSelector wordSelector = new WordSelector(possibleWordsList, selectedWordIndex);
        IHintGenerator hintGenerator = new HintGenerator(possibleWordsList[selectedWordIndex]);
        Game game = new Game(wordSelector, hintGenerator);
        game.start();
    }
}