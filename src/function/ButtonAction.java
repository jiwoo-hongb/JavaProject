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
            String result = Double.toString(calculatorLogic.calculate(inputSpace.getText()));
            inputSpace.setText(result);
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
