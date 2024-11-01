package function;

import java.util.Stack;

/**
 * {@code CalculatorLogic} 계산기의 핵심 로직을 담당하는 클래스이며, 입력된 수식 문자열을 처리하여 스택을 사용해 연산 우선순위에 맞춰 계산을 수행
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-10-22
 * @lastModified 2024-11-01
 *
 *            <ul>
 *            <header>[기능 전면 수정 도입 - 기존의 기능을 담당하던 클래스들을 전부 삭제하고 다시 재작성 한 클래스라는 것을 알려드립니다.]</header><br><br>
 *            <li>2024-10-30: CalculatorLogic 클래스 최초 생성</li><br>
 *            <li>2024-10-30: 새로운 사칙연산 계산 알고리즘 재작성</li><br>
 *
 *            <li>2024-10-31: 새로 작성한 코드 내의 오류 발생 수정 진행</li>
 *            </ul>
 */

public class CalculatorLogic {
    private Stack<Double> numStack = new Stack<>(); // 숫자를 저장하는 스택
    private Stack<Character> opStack = new Stack<>(); // 연산자를 저장하는 스택
    private StringBuilder num = new StringBuilder(); // 숫자를 임시 저장하는 StringBuilder

    /**
     * <li>주어진 수식 문자열을 계산하여 결과를 반환</li>
     *
     * @param inputText 계산할 수식 문자열
     * @return 계산 결과(double)
     */
    double calculate(String inputText) {
        preprocess(inputText); // 입력된 문자열 전처리

        // 모든 연산이 끝난 후 최종 결과 계산
        while (!opStack.isEmpty()) {
            double n1 = numStack.pop(); // 첫 번째 피연산자
            double n2 = numStack.pop(); // 두 번째 피연산자
            char op = opStack.pop(); // 연산자
            numStack.push(applyOperation(n2, n1, op)); // 연산 결과를 다시 스택에 추가
        }

        // 최종 결과 반환
        return numStack.isEmpty() ? 0 : numStack.pop();
    }

    /**
     * <li>입력된 수식 문자열을 전처리하여 숫자와 연산자를 각각 스택에 저장</li>
     *
     * @param inputText 계산할 수식 문자열
     */
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

    /**
     * <li>두 숫자와 연산자를 받아서 해당 연산을 수행</li>
     *
     * @param n1 첫 번째 피연산자
     * @param n2 두 번째 피연산자
     * @param oper 적용할 연산자
     * @return 연산 결과
     */
    private double applyOperation(double n1, double n2, char oper) {
        switch (oper) {
            case 'x':
                return n1 * n2; // 곱셈
            case '÷':
                if (n2 != 0) return n1 / n2; // 나눗셈 (0으로 나누는 경우 방지)
                else throw new ArithmeticException("0으로 나눌 수 없습니다.");
            case '+':
                return n1 + n2; // 덧셈
            case '-':
                return n1 - n2; // 뺄셈
            case '%':
                return n1 % n2; // 나머지 연산
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
    }

    /**
     * <li>주어진 연산자의 우선순위를 반환</li>
     *
     * @param op 우선순위를 확인할 연산자
     * @return 연산자의 우선순위 (높을수록 우선순위가 높음)
     */
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
