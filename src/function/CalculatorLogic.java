package function;

import java.util.Stack;

public class CalculatorLogic {
    private Stack<Double> numStack = new Stack<>();
    private Stack<Character> opStack = new Stack<>();
    private StringBuilder num = new StringBuilder();

    double calculate(String inputText) {
        preprocess(inputText); // 입력된 문자열 전처리

        // 모든 연산이 끝난 후 최종 결과 계산
        while (!opStack.isEmpty()) {
            double n1 = numStack.pop(); // 두 숫자를 꺼냄
            double n2 = numStack.pop();
            char op = opStack.pop(); // 연산자를 꺼냄
            numStack.push(applyOperation(n2, n1, op)); // 연산 결과를 다시 스택에 추가
        }

        // 최종 결과 반환
        return numStack.isEmpty() ? 0 : numStack.pop();
    }

    private void preprocess(String inputText) {
        numStack.clear();
        opStack.clear();
        num.setLength(0); // num 초기화

        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.charAt(i);

            // 연산자인 경우 처리
            if (ch == '-' || ch == '+' || ch == 'x' || ch == '÷' || ch == '%') {
                if (num.length() > 0) {
                    numStack.push(Double.valueOf(num.toString())); // 현재 숫자를 스택에 추가
                    num.setLength(0); // num 초기화
                }

                // 연산자 우선순위 처리
                while (!opStack.isEmpty() && precedence(ch) <= precedence(opStack.peek())) {
                    double n1 = numStack.pop();
                    double n2 = numStack.pop();
                    char oper = opStack.pop();
                    numStack.push(applyOperation(n2, n1, oper)); // 연산 적용
                }
                opStack.push(ch); // 연산자를 스택에 추가
            } else {
                num.append(ch); // 숫자 추가
            }
        }

        // 마지막 숫자 처리
        if (num.length() > 0) {
            numStack.push(Double.valueOf(num.toString())); // 마지막 숫자 스택에 추가
        }
    }

    private double applyOperation(double n1, double n2, char oper) {
        switch (oper) {
            case 'x':
                return n1 * n2;
            case '÷':
                if (n2 != 0) return n1 / n2; // 0으로 나누는 경우 방지
                else throw new ArithmeticException("0으로 나눌 수 없습니다.");
            case '+':
                return n1 + n2; // 덧셈
            case '-':
                return n1 - n2; // 뺄셈
            case '%':
                return n1 % n2;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
    }

    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case 'x':
            case '÷':
            case '%':
                return 2;
            default:
                return 0;
        }
    }
}
