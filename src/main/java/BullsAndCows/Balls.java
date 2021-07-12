package BullsAndCows;

/**
 * 1. 1-9 사이의 서로 다른 3자리 난수 생성 (컴퓨터) o
 * 2. 서로 다른 3자리 수를 입력 (사용자) o
 * 3. 각 자리 수 일치(스트라이크) or 다른 포지션에 존재(볼) 여부 확인 o
 * 4. 숫자 3개를 모두 맞췄을 때 게임 종료 o
 * 5. 게임 종료 후 다시 시작 or 완전히 종료 o
 */

import java.util.ArrayList;

import BullsAndCows.View.*;

import static BullsAndCows.View.ResultView.ending;
import static BullsAndCows.View.ResultView.viewScore;


public class Balls {
    private static int Strike = 0, Ball = 0;
    private static boolean whether = true;
    private static ArrayList<Integer> BALLS = new ArrayList<Integer>();

    public static void main(String[] args) {
        Balls Ball = new Balls();
        while (whether) {
            Ball.start();
        }

    }

    public void start() {
        Strike = 0;
        Ball = 0;

        generateBalls();

        InputView In = new InputView();
        ArrayList<Integer> digits = In.input();

        for (int i = 0; i < 3; i++) {
            isStrike(digits.get(i), BALLS.get(i));
        }

        for (Integer digit : digits) {
            isNothing(digit, BALLS);
        }

        System.out.println(digits);
        System.out.println(BALLS);

        viewScore(Strike, Ball);
        if (Strike == 3) {
            whether = ending();
        }

    }

    public static boolean isStrike(int number, int listNumber) {
        if (number == listNumber) {
            Strike++;
            Ball--;

            return true;
        }

        return false;
    }

    public static boolean isBall(int number, int listNumber) {
        return number != listNumber;
    }


    public static boolean isNothing(int number, ArrayList<Integer> list) {
        if (!list.contains(number)) {
            return true;
        }


        Ball++;

        /*
        1. 안에 있으면서
        2. 스트라이크가 아니면?
         */

        return false;
    }

    public static void generateBalls() {
        while (BALLS.size() < 3)
            generateBall();

    }

    public static int generateBall() {
        double randomValue = Math.random();
        int intValue = (int) (randomValue * 9 + 1);
        if (!BALLS.contains(intValue))
            BALLS.add(intValue);
        return intValue;
    }

    public static boolean endGame(int strike) {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
