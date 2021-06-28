package study;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private static Calculator calculator;
    private static Queue<String> operators = new LinkedList();
    private static ArrayList<Integer> numbers = new ArrayList();
    private static InputOutput inputOutput = new InputOutput();

    private static OutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private static String something;

    private static class InputOutput {
        public String getInput() {
            Scanner sc = new Scanner(System.in);
            return something = sc.nextLine();
        }
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        inputValues();
    }

    @Test
    public void start() {
        separate();
        calculate();
        System.setOut(originalOut);

        assertThat(out.toString()).contains("The Answer is 10");

    }


    @Test
    public void inputValues() {

        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertEquals(input, inputOutput.getInput());
    }

    @Test
    public void separate() {
        String value = something;
        String[] values = value.split(" ");

        for (String obj : values) {
            try {
                int number = Integer.parseInt(obj);
                numbers.add(number);
            } catch (NumberFormatException e) {
                operators.add(obj);
            } finally {

            }

            assertEquals(2, numbers.get(0));
        }
    }

    @After
    public void calculate() {
        int i = 0;
        int args_1 = numbers.get(0);
        int args_2;

        for (String obj : operators) {
            args_2 = numbers.get(i + 1);
            switch (obj) {
                case "+":
                    args_1 = calculator.add(args_1, args_2);
                    break;
                case "-":
                    args_1 = calculator.subtract(args_1, args_2);
                    break;
                case "*":
                    args_1 = calculator.multiply(args_1, args_2);
                    break;
                case "/":
                    args_1 = calculator.divide(args_1, args_2);
                    break;
            }
            i = i + 1;
        }

        int actual = args_1;
        assertThat(actual).isEqualTo(10);

        System.out.println("The Answer is " + actual);


    }

    // 계산기 클래스
    public class Calculator {

        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public int divide(int a, int b) {
            return a / b;
        }

    }
}

