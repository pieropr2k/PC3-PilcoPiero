import org.example.DependencyInjector;
import org.example.IHintGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DependencyInjectorTest {
    @Test
    void multipleTriesButWinTesting() {
        DependencyInjector dependencyInjector = new DependencyInjector();
        assertThat(dependencyInjector).isNotEqualTo(null);
    }

}
