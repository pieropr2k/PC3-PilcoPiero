package org.example;

public class Main {
    public static void main(String[] args) {
        String[] possibleWordsList = new String[]{"example", "campeon", "maraton", "futbol"};
        int selectedWordIndex = 1;
        int maximumAttempts = 5;
        Game game = new Game(possibleWordsList, maximumAttempts);
        game.start(1);
        String[] allAttempts = new String[]{"torre", "mano", "arbol", "exam"};
        for(String attempt :allAttempts) {
            game.tryToGuessLetter(attempt);
        }
        System.out.println(game.winningAdvice());
    }
}