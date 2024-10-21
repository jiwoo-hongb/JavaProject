package function;

public class InputHandler {
    private StringBuilder currentInput; //현재 입력값
    private double firstOperand;
    private double secondOperand;
    private String operator;

    public InputHandler() {
        currentInput = new StringBuilder();
    }

    public String getCurrentInput() {
        return currentInput.toString();
    }

    public void appendInput(String input) {
        currentInput.append(input);
    }

    public void clearAll() {
        currentInput.setLength(0);
    }

    public void clearCurrent(){
        currentInput.setLength(0);
    }

    public void deleteLastInput() {
        if(currentInput.length() > 0){
            currentInput.deleteCharAt(currentInput.length() - 1);
        }
    }

    public double getFirstOperand() {
        if (firstOperand == 0 && currentInput.length() > 0) {
            firstOperand = Double.parseDouble(currentInput.toString());
        }
        return firstOperand;
    }

    public void setOperator(String operator) {
        if(currentInput.length() > 0){
            firstOperand = getFirstOperand();
            this.operator = operator;
            clearCurrent();
        }
    }

    public String getOperator() {
        return this.operator;
    }
    public  void setResult(double result) {
        currentInput.setLength(0);
        currentInput.append(result);
    }

}
