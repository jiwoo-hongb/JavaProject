package function;

public class InputHandler {
    StringBuilder currentInput; //현재 입력값

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

}
