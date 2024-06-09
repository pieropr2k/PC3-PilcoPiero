import org.example.HintGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HintGeneratorTest {
    private HintGenerator hintGenerator;
    @BeforeEach
    void setUp(){
        this.hintGenerator = new HintGenerator("example");
    }

    @Test
    void getInitialHint() {
        String hint = hintGenerator.generateInitialHint();
        assertThat(hint).isEqualTo("_______");
    }

    @Test
    void getIncorrectHint() {
        String hint = hintGenerator.generateHint("hablando");
        assertThat(hint).isEqualTo("_______");
    }

    @Test
    void getPartialCorrectHint() {
        String hint = hintGenerator.generateHint("examen");
        assertThat(hint).isEqualTo("exam___");
    }

    @Test
    void getCorrectHint() {
        String hint = hintGenerator.generateHint("example");
        assertThat(hint).isEqualTo("example");
    }
}
