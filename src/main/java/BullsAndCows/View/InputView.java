package BullsAndCows.View;

import BullsAndCows.Exception.SameNumberException;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public int[] input()  {
        int[] digits = {};
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        System.out.println("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();

        while (input.length() != 3) {
            System.out.println("서로 다른 3 자리의 숫자를 입력해 주세요. : ");
            scanner.nextLine();

            input = scanner.nextLine();
        }

        try {
            int first = Integer.parseInt(input.substring(0));
            int second = Integer.parseInt(input.substring(1));
            int third = Integer.parseInt(input.substring(2));

            set.add(first);
            set.add(second);
            set.add(third);

            inspectSameDigits(set.size());

            digits[0] = first;
            digits[1] = second;
            digits[2] = third;

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