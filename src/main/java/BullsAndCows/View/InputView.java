package BullsAndCows.View;

import BullsAndCows.Exception.SameNumberException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public ArrayList<Integer> input() {
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        ArrayList<Integer> digits = new ArrayList<Integer>();

        System.out.println("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();

        while (input.length() != 3) {
            System.out.println("서로 다른 3 자리의 숫자를 입력해 주세요. : ");
            scanner.nextLine();

            input = scanner.nextLine();
        }

        try {
            int first = Integer.parseInt(input.substring(0,1));
            int second = Integer.parseInt(input.substring(1,2));
            int third = Integer.parseInt(input.substring(2,3));

            set.add(first);
            set.add(second);
            set.add(third);

            inspectSameDigits(set.size());

            digits.add(first);
            digits.add(second);
            digits.add(third);

        } catch (NumberFormatException ex) {
            System.out.println("숫자를 입력해 주세요.");
            scanner.nextLine();
            input();
        } catch (SameNumberException ex) {
            scanner.nextLine();
            input();
        }

        return digits;
    }

    private static void inspectSameDigits(int num) throws SameNumberException {
        if (num != 3) {
            throw new SameNumberException("'서로 다른' 3 가지 숫자를 입력해 주세요. ");
        }

    }
}