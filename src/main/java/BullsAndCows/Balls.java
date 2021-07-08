package BullsAndCows;

import java.util.LinkedHashSet;

public class Balls {
    
    public static boolean isStrike(int number, int setNumber) {
        return number == setNumber;
    }

    public static boolean isBall(int number, int setNumber) {
        return number != setNumber;
    }

    public static void generateBalls(LinkedHashSet<Integer> set) {
        while (set.size() < 3) {
            double randomValue = Math.random();
            int intValue = (int) (randomValue * 9) + 1;
            set.add(intValue);
        }
    }


}
