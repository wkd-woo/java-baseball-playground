package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import study.BullsAndCowsTest;

import static study.BullsAndCowsTest.ball;
import static study.BullsAndCowsTest.strike;

public class ResultView {
    static Scanner scanner = new Scanner(System.in);
    static int result = 0;

    public static void viewScore() {
        if (ball != 0)
            System.out.print(ball + "볼 ");
        if (strike != 0)
            System.out.print(strike + "스트라이크");
        if ((strike == 0) && (ball == 0))
            System.out.print("숫자가 하나도 맞지 않아요!");

        System.out.println("");

    }

    public static boolean endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        try {
            System.out.println("게임을 새로시작하려면 1, 종료하려면 2를 입력하세요.");
            result = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("1 또는 2의 숫자를 입력해 주세요.");
            scanner.nextInt();
            result = scanner.nextInt();
        }

        if (result != 1 || result != 2) {
            System.out.println("1 또는 2의 숫자를 입력해 주세요.");
        }

        if (result == 2) {
            System.out.println("게임을 종료합니다.");
            return false;
        }

        return true;
    }

}
