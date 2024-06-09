package org.example;

// Clase Game modificada
public class Game {
    private final IWordSelector wordSelector;
    private IHintGenerator hintGenerator;
    private IFeedbackGenerator feedbackGenerator;
    private String wordToGuess;
    private final int maximumAttempts;
    private int remainingAttempts;
    private boolean doYouWon;

    public Game(String[] possibleWords, int maximumAttempts) {
        this.wordSelector = DependencyInjector.wordSelector(possibleWords);
        this.maximumAttempts = maximumAttempts;
        this.remainingAttempts = maximumAttempts;
        this.doYouWon = false;
    }
    public void start(int selectWordIndex) {
        this.wordToGuess = this.wordSelector.selectWord(selectWordIndex);
        this.hintGenerator = DependencyInjector.hintGenerator(wordToGuess);
        this.feedbackGenerator = new FeedbackGenerator(wordToGuess);
        System.out.println("Tienes un maximo de: " + this.maximumAttempts + " intentos");
        String hint = this.hintGenerator.generateHint("");
        System.out.println("Hint: " + hint);
    }

    public void tryToGuessLetter(String tryString) {
        System.out.println("Tu intento: " + tryString);
        if (remainingAttempts==1) {
            System.out.println(this.hintGenerator.getSpecialHint());
        }
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