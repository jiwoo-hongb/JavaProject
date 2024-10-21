package function;
/**
 * - 10.19: 첫 BtnClickListener 클래스 생성
 */

/**
 * Main_Gui클래스로부터 ButtonEvent 제공
 * Click 이벤트시 cmd에 결과 출력
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnClickListener implements ActionListener {
    JLabel solutionLabel;
    JLabel resultLabel;

    InputHandler inputHandler;
    ACHandler acHandler;
    CHandler cHandler;
    BackspaceHandler backspaceHandler;
    SignChangeHandler signChangeHandler;
    OperatorHandler operatorHandler;

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand(); // 버튼 텍스트 가져오기
        System.out.println(cmd);

        switch (cmd) {
            case "AC": // 모든 입력 초기화
                acHandler.clearAll(inputHandler);
                solutionLabel.setText("0");
                resultLabel.setText("0");
                break;

            case "CE":
                cHandler.clearCurrent(inputHandler);
                solutionLabel.setText(inputHandler.getCurrentInput());
                break;

            case "←":
                backspaceHandler.deleteLast(inputHandler);
                solutionLabel.setText(inputHandler.getCurrentInput());
                break;

            case "±":
                signChangeHandler.changeSign(inputHandler);
                solutionLabel.setText(inputHandler.getCurrentInput());
                break;

            case "÷":
            case "×":
            case "–":
            case "+":
                operatorHandler.setOperator(cmd, inputHandler);
                solutionLabel.setText(inputHandler.getCurrentInput() + " " + cmd);
                break;

            default: // 숫자 및 소수점 입력 처리
                inputHandler.appendInput(cmd);
                solutionLabel.setText(inputHandler.getCurrentInput());
                break;
        }
    }
}
