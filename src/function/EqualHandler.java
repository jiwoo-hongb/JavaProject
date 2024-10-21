package function;

public class EqualHandler {
    public void calculate(InputHandler inputHandler, CalculatorLogic calculatorLogic){
        double result = calculatorLogic.calculate(inputHandler.getFirstOperand(),
                inputHandler.getSecondOperand(),
                inputHandler.getOperator());
        inputHandler.setResult(result);
    }
}
