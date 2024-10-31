/**
 * ButtonAction 클래스는 계산기 버튼의 클릭 이벤트를 처리하는 ActionListener 구현체입니다.
 * 연산 입력, 계산 수행, 입력 초기화 등의 기능을 제공합니다.
 */
package function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * ButtonAction 클래스는 계산기의 버튼 클릭에 따른 동작을 정의하고, 입력 필드에 대한
 * 계산 로직을 수행하여 결과를 표시합니다.
 */
public class ButtonAction implements ActionListener {
    private JTextField inputSpace; // 계산기 입력 및 결과 표시 공간
    private CalculatorLogic calculatorLogic = new CalculatorLogic(); // 계산 수행 로직을 포함한 클래스
    private String prevOperation = ""; // 이전 연산자 저장

    /**
     * ButtonAction 생성자는 JTextField를 초기화하여 버튼 클릭 시 입력된 값을 처리할 수 있도록 설정합니다.
     *
     * @param inputSpace 계산기 입력 및 결과를 표시하는 JTextField
     */
    public ButtonAction(JTextField inputSpace) {
        this.inputSpace = inputSpace;
    }

    /**
     * 버튼 클릭 시 호출되는 메서드로, 입력된 값을 처리하여 계산을 수행하거나, 입력된 연산자를 조정합니다.
     * "C"는 입력 초기화, "="는 계산 결과 표시, 연산자는 기존 값에 연산자를 추가합니다.
     *
     * @param e 발생한 ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String inputValue = ((JButton) e.getSource()).getText();
        if (inputValue.equals("C")) {
            inputSpace.setText(""); // "C" 버튼 클릭 시 입력 공간 초기화
        } else if (inputValue.equals("=")) {
            // 입력된 표현식을 계산기 로직에 전달하여 결과를 표시
            String expression = inputSpace.getText()
                    .replace("×", "x")  // 곱셈 기호 변경
                    .replace("÷", "÷");  // 나눗셈 기호 (변경 없음)

            try {
                String result = Double.toString(calculatorLogic.calculate(expression));
                inputSpace.setText(result); // 결과 표시
            } catch (Exception ex) {
                inputSpace.setText("Error"); // 오류 발생 시 오류 메시지 표시
                System.out.println("Error in calculation: " + ex.getMessage()); // 콘솔에 오류 메시지 출력
            }
        } else if (inputValue.matches("[÷+x-]") && !inputSpace.getText().isEmpty()) {
            handleOperator(inputValue); // 연산자가 입력된 경우 처리
        } else {
            inputSpace.setText(inputSpace.getText() + inputValue); // 숫자 버튼 입력 시 텍스트 추가
        }
        prevOperation = inputValue; // 이전 연산자 업데이트
    }

    /**
     * 연산자를 처리하여 이전 연산자가 있으면 이를 대체하고, 없으면 입력 공간에 추가합니다.
     *
     * @param inputValue 현재 입력된 연산자
     */
    private void handleOperator(String inputValue) {
        String currentText = inputSpace.getText();
        if (prevOperation.matches("[÷+x-]")) {
            // 이전에 입력된 연산자가 있다면 대체
            inputSpace.setText(currentText.substring(0, currentText.length() - 1) + inputValue);
        } else {
            inputSpace.setText(currentText + inputValue); // 연산자가 없으면 추가
        }
    }
}
