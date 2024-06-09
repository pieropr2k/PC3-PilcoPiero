import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GameTest {
    String[] possibleWordsList;
    int selectedWordIndex;

    @BeforeEach
    void setUp(){
        this.possibleWordsList = new String[]{"example", "campeon", "maraton", "futbol"};
        this.selectedWordIndex = 1;
    }

    @Test
    void goodInit() {
        IWordSelector wordSelector = new WordSelector(possibleWordsList, selectedWordIndex);
        IHintGenerator hintGenerator = new HintGenerator(possibleWordsList[selectedWordIndex]);
        Game game = new Game(wordSelector, hintGenerator);
        assertDoesNotThrow(() -> {
            game.start();
        });
    }

    @Test
    void definitiveBadInit() {
        Game game = new Game(null, null);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(game::start);
    }

    @Test
    void initOnlyWithWordSelector() {
        IWordSelector wordSelector = new WordSelector(possibleWordsList, selectedWordIndex);
        Game game = new Game(wordSelector, null);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(game::start);
    }

    @Test
    void initOnlyWithHintGenerator() {
        IHintGenerator hintGenerator = new HintGenerator(possibleWordsList[selectedWordIndex]);
        Game game = new Game(null, hintGenerator);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(game::start);
    }
}
