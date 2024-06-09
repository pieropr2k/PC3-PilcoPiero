import org.example.Game;
import org.example.HintGenerator;
import org.example.WordSelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordSelectorTest {
    private WordSelector wordSelector;
    String[] possibleWordsList;
    int selectedWordIndex;

    @BeforeEach
    void setUp(){
        this.possibleWordsList = new String[]{"campeones", "example", "maraton", "futbol"};
    }

    @Test
    void getIndexMinusOrZero() {
        this.selectedWordIndex = -1;
        this.wordSelector = new WordSelector(possibleWordsList);
        assertThrows(IllegalArgumentException.class, () -> {
            wordSelector.selectWord(selectedWordIndex);
        });
    }

    @Test
    void getIndexOutOfLength() {
        this.selectedWordIndex = 5;
        this.wordSelector = new WordSelector(possibleWordsList);
        assertThrows(IllegalArgumentException.class, () -> {
            wordSelector.selectWord(selectedWordIndex);
        });
    }

    @Test
    void getCorrectItem() {
        this.selectedWordIndex = 1;
        this.wordSelector = new WordSelector(possibleWordsList);
        assertThat(wordSelector.selectWord(selectedWordIndex)).isEqualTo("campeones");
    }

    @Test
    void getCorrectItemLength() {
        this.selectedWordIndex = 1;
        this.wordSelector = new WordSelector(possibleWordsList);
        assertThat(wordSelector.selectWord(selectedWordIndex).length()).isEqualTo(9);
    }
}
