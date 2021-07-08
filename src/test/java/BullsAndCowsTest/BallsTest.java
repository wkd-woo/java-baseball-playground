package BullsAndCowsTest;

import BullsAndCows.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static BullsAndCows.Balls.generateBalls;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallsTest {
    private LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
    private LinkedHashSet<Integer> test = new LinkedHashSet<Integer>();

    @BeforeEach
    void init(){
        generateBalls(set);
    }

    @Test
    @DisplayName("스트라이크_볼_나띵_여부")
    void 스트라이크_볼_나띵(){
        assertThat(Balls.isStrike(1,1)).isTrue();
        assertThat(Balls.isStrike(1,2)).isFalse();
        assertThat(Balls.isBall(1,3)).isTrue();
        assertThat(Balls.isBall(2,2)).isFalse();
    }

    @Test
    @DisplayName("숫자_3개_생성")
    void 볼_생성(){
        assertThat(set.size()).isEqualTo(3);
    }

}