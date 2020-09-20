import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите в через пробел вычисление +,-,/ или * над арабскими или римскими числами:");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String temp = scanner.nextLine();
        try {
            String[] values = temp.split(" ");
            String firstNumber = values[0];
            String operator = values[1];
            String secondNumber = values[2];

            if (inputIsPositiveInteger(firstNumber) && inputIsPositiveInteger(secondNumber)) {

                int firstNum = Integer.parseInt(firstNumber);
                int secondNum = Integer.parseInt(secondNumber);

                double finalNum = calculator.calculate(firstNum, operator, secondNum);
                System.out.println(finalNum);

            } else if (!inputIsPositiveInteger(firstNumber) && !inputIsPositiveInteger(secondNumber)) {

                int firstInt = new RomanNumeral(firstNumber).toInt();
                int secondInt = new RomanNumeral(secondNumber).toInt();

                double finalNum = calculator.calculate(firstInt, operator, secondInt);
                String num = new RomanNumeral((int) finalNum).toString();
                System.out.println(num);
            } else {
                throw new NullPointerException("Invalid input");
            }
        }
        catch (NullPointerException ex) {
            System.out.println("Incorrect: " + ex.toString());
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Incorrect input or operation ");
        }
        catch(ArithmeticException ex) {
            System.out.println("Incorrect: " + ex.toString());
        }

    }

    static boolean inputIsPositiveInteger(String input) {
        String regex = "[0-9]+";
        return input.matches(regex);
    }

}
