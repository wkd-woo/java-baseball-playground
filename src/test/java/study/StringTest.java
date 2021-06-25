package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 요구사항 1
     */
    @Test
    @DisplayName("separating string bt semicolon")
    void separate(){
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1","2");

        String[] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }


    /**
     * 요구사항 2
     */
    @Test
    @DisplayName("eliminating parenthesis")
    void eliminate(){
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     */
    @Test
    @DisplayName("Selecting specific letter")
    void select(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            char actual = "abc".charAt(4);
            assertThat(actual).isEqualTo('b');
        }).withMessageContaining("String index out of range");
    }

}
