package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Set Collection Test")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    /**
     * 요구사항 1
     */
    @Test
    @DisplayName("Set 크기 확인")
    void checkSize() {
        int actual = numbers.size();
        assertEquals(actual, 3);
    }

    /**
     * 요구사항 2
     *
     * @param argument
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set argument 확인")
    void contains(int argument) {
        assertThat(numbers.contains(argument)).isTrue();
    }

    /**
     * 요구사항 3
     *
     * @param argument
     */
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set argument 확인")
    void contains2(int argument, boolean whether) {
        boolean actual = numbers.contains(argument);
        assertThat(actual).isEqualTo(whether);
    }
}
