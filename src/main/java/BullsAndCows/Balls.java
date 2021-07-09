package BullsAndCows;

/**
 * 1. 1-9 사이의 서로 다른 3자리 난수 생성 (컴퓨터) o
 * 2. 서로 다른 3자리 수를 입력 (사용자) o
 * 3. 각 자리 수 일치(스트라이크) or 다른 포지션에 존재(볼) 여부 확인 o
 * 4. 숫자 3개를 모두 맞췄을 때 게임 종료 o
 * 5. 게임 종료 후 다시 시작 or 완전히 종료
 */

import java.util.LinkedHashSet;

import BullsAndCows.View.*;


public class Balls {
    private static int Strike, Ball;

    public void start(){
        Strike = 0; Ball = 0;
        InputView In = new InputView();
        int[] digits = In.input();



    }

    public static boolean isStrike(int number, int setNumber) {
        return number == setNumber;
    }

    public static boolean isBall(int number, int setNumber) {
        return number != setNumber;
    }

    public static boolean isNothing(int number, LinkedHashSet<Integer> set) {
        return !set.contains(number);
    }

    public static void generateBalls(LinkedHashSet<Integer> set) {
        while (set.size() < 3) {
            double randomValue = Math.random();
            int intValue = (int) (randomValue * 9) + 1;
            set.add(intValue);
        }
    }


    public static boolean endGame(int strike) {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
