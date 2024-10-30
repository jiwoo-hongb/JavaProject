package function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {
    private JTextField inputSpace;
    private CalculatorLogic calculatorLogic = new CalculatorLogic();
    private String prevOperation = "";

    public ButtonAction(JTextField inputSpace) {
        this.inputSpace = inputSpace;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String inputValue = ((JButton) e.getSource()).getText();
        if (inputValue.equals("C")) {
            inputSpace.setText("");
        } else if (inputValue.equals("=")) {
            // 입력값의 연산자를 변환
            String expression = inputSpace.getText()
                    .replace("×", "x")  // 곱셈 기호 변경
                    .replace("÷", "÷");  // 나눗셈 기호 변경 (변경 없음)

            try {
                String result = Double.toString(calculatorLogic.calculate(expression));
                inputSpace.setText(result);
            } catch (Exception ex) {
                inputSpace.setText("Error"); // 오류 발생 시 표시
                System.out.println("Error in calculation: " + ex.getMessage()); // 콘솔에 오류 메시지 출력
            }
        } else if (inputValue.matches("[÷+x-]") && !inputSpace.getText().isEmpty()) {
            handleOperator(inputValue);
        } else {
            inputSpace.setText(inputSpace.getText() + inputValue);
        }
        prevOperation = inputValue;
    }


    private void handleOperator(String inputValue) {
        String currentText = inputSpace.getText();
        if (prevOperation.matches("[÷+x-]")) {
            inputSpace.setText(currentText.substring(0, currentText.length() - 1) + inputValue);
        } else {
            inputSpace.setText(currentText + inputValue);
        }
    }
}
