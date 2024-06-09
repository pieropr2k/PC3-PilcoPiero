import org.example.Game;
import org.example.HintGenerator;
import org.example.WordSelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WordSelectorTest {
    private WordSelector wordSelector;
    String[] possibleWordsList;
    int selectedWordIndex;

    @BeforeEach
    void setUp(){
        this.possibleWordsList = new String[]{"campeones", "example", "maraton", "futbol"};
        this.selectedWordIndex = 1;
        this.wordSelector = new WordSelector(possibleWordsList, selectedWordIndex);
    }

    @Test
    void getCorrectItem() {
        assertThat(wordSelector.selectWord()).isEqualTo("campeones");
    }

    @Test
    void getCorrectItemLength() {
        assertThat(wordSelector.selectWord().length()).isEqualTo(9);
    }
}
