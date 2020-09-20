public class Calculator{

    public Calculator(){}

    public static double calculate(int firstNum, String operator, int secondNum) {

        double resultNum = 0;
        switch (operator) {
            case "+":
                resultNum = firstNum + secondNum;
                break;
            case "-":
                resultNum = firstNum - secondNum;
                break;
            case "/":
                resultNum = firstNum / secondNum;
                break;
            case "*":
                resultNum = firstNum * secondNum;
                break;
            default:
                throw new ArithmeticException("num is" + resultNum);
        }
        return resultNum;
    }
}