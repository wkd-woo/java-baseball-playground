package study;

/**
 * 1) 1-9 사이의 서로 다른 3자리 난수 생성 (컴퓨터)    o
 * 2) 서로 다른 3자리 수를 입력 (사용자)    o
 * 3) 입력 값 적합 여부를 확인하는 예외처리    o
 * 4) 각 자리 수 일치(스트라이크) or 다른 포지션에 존재(볼) 여부 확인 o
 * 5) 숫자 3개를 모두 맞췄을 때 게임 종료 o
 * 6) 게임 종료 후 다시 시작 or 완전히 종료 o
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import view.ResultView;
import view.InputView;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BullsAndCowsTest {
    private static OutputStream out = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(); // 3 자리 수
    public static int strike, ball;
    private static boolean whether = true;


    @BeforeEach()
    public void setUp() {
        makeDigits();

    }

    @Test
    public void start() {
        while (whether) {
            checkDigits(new int[]{1, 2, 3});
        }

    }

    @DisplayName("3 자리 난수 생성")
    @Test
    public void makeDigits() {  // 1) 3 자리 난수 생성
        while (set.size() < 3) {
            double dValue = Math.random();
            int random = (int) (dValue * 10);
            set.add(random);
        }
        System.out.println(set);

        assertEquals(3, set.size());
    }

    @DisplayName("숫자 체크")
    @ParameterizedTest
    @MethodSource("generateData")
    public void checkDigits(int[] numbers) {
        strike = 0;
        ball = 0;

        Iterator<Integer> iterator = set.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            checkStrike(numbers[i++], iterator.next());
        }

        for (int number : numbers) {
            checkBall(number);
        }

        ResultView.viewScore();

        if (strike == 3) {
            whether = ResultView.endGame();
        }
        assertEquals(3, i);
    }

    public static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}),
                Arguments.of(new int[]{5, 4, 8}),
                Arguments.of(new int[]{3, 1, 7}));
    }

    @DisplayName("스트라이크 체크")
    @ParameterizedTest
    @CsvSource({"1, 1", "1, 3"})
    public void checkStrike(int argOfNum, int argOfSet) {
        if (argOfNum == argOfSet) {
            strike++;
            ball--;
        }
        assertThat(strike).isNotNull();
    }

    @DisplayName("볼 체크")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void checkBall(int argOfNum) {
        if (set.contains(argOfNum)) {
            ball++;
        }
        assertThat(ball).isNotNull();
    }

}

