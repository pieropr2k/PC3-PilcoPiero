package org.example;

// Clase Game modificada
public class Game {
    private final IWordSelector wordSelector;
    private final IHintGenerator hintGenerator;
    private IFeedbackGenerator feedbackGenerator;
    private String wordToGuess;
    private int maximumAttempts;
    private int remainingAttempts;
    private boolean doYouWon;

    // Constructor con inyección de dependencias
    public Game(IWordSelector wordSelector, IHintGenerator hintGenerator, int maximumAttempts) {
        this.wordSelector = wordSelector;
        this.hintGenerator = hintGenerator;
        this.maximumAttempts = maximumAttempts;
        this.remainingAttempts = maximumAttempts;
        this.doYouWon = false;
    }
    public void start(int selectWordIndex) {
        if (wordSelector == null || hintGenerator == null) {
            throw new IllegalArgumentException("No estan los atributos");
        }
        this.wordToGuess = this.wordSelector.selectWord(selectWordIndex);
        System.out.println("Tienes un maximo de: " + this.maximumAttempts + " intentos");
        this.feedbackGenerator = new FeedbackGenerator(wordToGuess);
        String hint = this.hintGenerator.generateHint("");
        System.out.println("Hint: " + hint);

    }

    public void tryToGuessLetter(String tryString) {
        System.out.println("Tu intento: " + tryString);
        setIntents(remainingAttempts-1);
        if (remainingAttempts<0) {
            throw new RuntimeException(winningAdvice());
        }
        if (this.wordToGuess.equals(tryString)) {
            setDoYouWon(true);
        } else {
            System.out.println("Feedback: " + feedbackGenerator.generateFeedback(tryString));
            String hint = this.hintGenerator.generateHint(tryString);
            System.out.println("Hint: " + hint);
        }
    }

    public boolean getDoYouWon(){
        return this.doYouWon;
    }

    public void setDoYouWon(boolean doYouWon) {
        this.doYouWon = doYouWon;
    }

    public void setIntents(int newIntents) {
        this.remainingAttempts = newIntents;
    }

    public int getRemainingAttempts(){
        return this.remainingAttempts;
    }

    public String getWordToGuess(){
        return this.wordToGuess;
    }

    public String winningAdvice(){
        return doYouWon ? "You win bro, congrats" : "You lose. Correct word is: " + this.wordToGuess;
    }
}