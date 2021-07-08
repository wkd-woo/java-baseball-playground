package BullsAndCowsTest;

import BullsAndCows.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ValidationUtilsTest {


    @Test
    @DisplayName("1-9 사이의 숫자")
    void 숫자_1_9(){

        assertThat(ValidationUtils.isValid(1)).isTrue();
        assertThat(ValidationUtils.isValid(9)).isTrue();
        assertThat(ValidationUtils.isValid(0)).isFalse();
        assertThat(ValidationUtils.isValid(10)).isFalse();
    }

}