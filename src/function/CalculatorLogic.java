package function;

public class CalculatorLogic {

    public double calculate(double firstOperand, double secondOperand, String operator) {
        double result = 0;

        switch (operator) {
            case "+":
                result = add(firstOperand, secondOperand);
                break;
            case "–":
                result = subtract(firstOperand, secondOperand);
                break;
            case "×":
                result = multiply(firstOperand, secondOperand);
                break;
            case "÷":
                result = divide(firstOperand, secondOperand);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        return formatResult(result);
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // 결과가 소수점이 없을 경우 정수로 반환, 그렇지 않으면 그대로 반환
    private double formatResult(double result) {
        if (result == (int) result) {
            return (int) result; // 정수로 변환
        } else {
            return result; // 소수점 그대로 반환
        }
    }
}
