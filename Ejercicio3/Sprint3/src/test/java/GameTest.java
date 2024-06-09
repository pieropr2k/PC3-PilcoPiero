import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class GameTest {
    String[] possibleWordsList;
    int selectedWordIndex;
    int maximumAttempts;
    Game game;

    @BeforeEach
    void setUp(){
        this.possibleWordsList = new String[]{"example", "campeon", "maraton", "futbol"};

        this.maximumAttempts = 4;
        this.game = new Game(possibleWordsList, maximumAttempts);
        this.selectedWordIndex = 1;

        game.start(selectedWordIndex);
    }

    @Test
    void goodInit() {
        assertDoesNotThrow(() -> {
            game.start(selectedWordIndex);
        });
    }

    @Test
    void badFirstTryTesting() {
        game.tryToGuessLetter("hola");
        assertThat(game.getDoYouWon()).isEqualTo(false);
    }

    @Test
    void perfectFirstTryTesting() {
        game.tryToGuessLetter("example");
        assertThat(game.getDoYouWon()).isEqualTo(true);
    }

    @Test
    void goodWinningAdvice() {
        game.tryToGuessLetter("example");
        assertThat(game.winningAdvice()).isEqualTo("You win bro, congrats");
    }

    @Test
    void badWinningAdvice() {
        game.tryToGuessLetter("arbol");
        assertThat(game.winningAdvice()).isEqualTo("You lose. Correct word is: " + this.game.getWordToGuess());
    }

    @Test
    void numberOfRemainingTriesTesting() {
        game.tryToGuessLetter("arbol");
        game.tryToGuessLetter("examen");
        assertThat(game.getRemainingAttempts()).isEqualTo(maximumAttempts-2);
    }

    @Test
    void multipleTriesButWinTesting() {
        game.tryToGuessLetter("arbol");
        game.tryToGuessLetter("example");
        assertThat(game.getDoYouWon()).isEqualTo(true);
    }

    @Test
    void illegalGamesTesting() {
        game.tryToGuessLetter("arbol");
        game.tryToGuessLetter("arbol");
        game.tryToGuessLetter("arbol");
        game.tryToGuessLetter("arbol");
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    game.tryToGuessLetter("arbol");
                });
    }
}
