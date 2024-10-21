package function;

public class DecimalHandler {
    public void addDecimalPoint(InputHandler inputHandler) {
        if (!inputHandler.getCurrentInput().contains(".")) {
            inputHandler.appendInput(".");
        }
    }
}
