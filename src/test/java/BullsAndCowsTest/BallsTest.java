package BullsAndCowsTest;

import BullsAndCows.Balls;
import BullsAndCows.ValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import static BullsAndCows.Balls.generateBalls;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallsTest {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private ArrayList<Integer> test = new ArrayList<Integer>();

    @BeforeEach
    void init(){
        generateBalls();
    }

    @Test
    @DisplayName("스트라이크_볼_나띵_여부")
    void 스트라이크_볼_나띵(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertThat(Balls.isStrike(1,1)).isTrue();
        assertThat(Balls.isStrike(1,2)).isFalse();
        assertThat(Balls.isBall(1,3)).isTrue();
        assertThat(Balls.isBall(2,2)).isFalse();
        assertThat(Balls.isNothing(1,list)).isFalse();
        assertThat(Balls.isNothing(4,list)).isTrue();

    }

    @Test
    @DisplayName("숫자_3개_생성")
    void 볼_생성(){
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("삼진_아웃")
    void 스트라이크_아웃(){
        assertThat(Balls.endGame(3)).isTrue();
        assertThat(Balls.endGame(2)).isFalse();
    }

    @Test
    void 랜덤_수(){
        assertThat(ValidationUtils.isValid(Balls.generateBall())).isTrue();

    }

}