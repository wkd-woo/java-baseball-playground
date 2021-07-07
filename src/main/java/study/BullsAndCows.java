package study;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import view.ResultView;
import view.InputView;

public class BullsAndCows {
    private static LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(); // 3 자리 수
    public static int strike, ball;
    private static boolean whether = true;

    public static void main(String[] args) {
        BullsAndCows game = new BullsAndCows();
        game.makeDigits();

    }


    public void makeDigits() {  // 1) 3 자리 난수 생성
        while (set.size() < 3) {
            double dValue = Math.random();
            int random = (int) (dValue * 10);
            set.add(random);
        }
        System.out.println(set);

    }

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
    }


    public void checkStrike(int argOfNum, int argOfSet) {
        if (argOfNum == argOfSet) {
            strike++;
            ball--;
        }
    }

    public void checkBall(int argOfNum) {
        if (set.contains(argOfNum)) {
            ball++;
        }
    }

}

