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
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertThat(Balls.isStrike(1,1)).isTrue();
        assertThat(Balls.isStrike(1,2)).isFalse();
        assertThat(Balls.isBall(1,3)).isTrue();
        assertThat(Balls.isBall(2,2)).isFalse();
        assertThat(Balls.isNothing(1,set)).isFalse();
        assertThat(Balls.isNothing(4,set)).isTrue();

    }

    @Test
    @DisplayName("숫자_3개_생성")
    void 볼_생성(){
        assertThat(set.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("삼진_아웃")
    void 스트라이크_아웃(){
        assertThat(Balls.endGame(3)).isTrue();
        assertThat(Balls.endGame(2)).isFalse();
    }

}