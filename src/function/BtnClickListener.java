package function;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnClickListener implements ActionListener {

    JLabel solutionLabel;
    JLabel resultLabel;

    InputHandler inputHandler;
    CalculatorLogic calculatorLogic;
    ACHandler acHandler;
    CHandler cHandler;
    BackspaceHandler backspaceHandler;
    EqualHandler equalHandler;
    SignChangeHandler signChangeHandler;
    OperatorHandler operatorHandler;
    DecimalHandler decimalHandler;

    public BtnClickListener(JLabel solutionLabel, JLabel resultLabel) {
        this.solutionLabel = solutionLabel;
        this.resultLabel = resultLabel;
        this.inputHandler = new InputHandler();
        this.calculatorLogic = new CalculatorLogic();
        this.acHandler = new ACHandler();
        this.cHandler = new CHandler();
        this.backspaceHandler = new BackspaceHandler();
        this.equalHandler = new EqualHandler();
        this.signChangeHandler = new SignChangeHandler();
        this.operatorHandler = new OperatorHandler();
        this.decimalHandler = new DecimalHandler();
    }

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

            case "=":
                equalHandler.calculate(inputHandler, calculatorLogic);
                resultLabel.setText(String.valueOf(inputHandler.getCurrentInput()));
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

            case ".":
                decimalHandler.addDecimalPoint(inputHandler);
                solutionLabel.setText(inputHandler.getCurrentInput());
                break;

            default: // 숫자 및 소수점 입력 처리
                inputHandler.appendInput(cmd);
                solutionLabel.setText(inputHandler.getCurrentInput());
                break;
        }
    }
}
