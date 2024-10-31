/**
 * Design_forGui 클래스는 계산기 GUI에 사용할 색상과 폰트를 정의하고,
 * 버튼과 입력 공간의 스타일을 설정하는 기능을 제공합니다.
 */
package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Design_forGui 클래스는 계산기 인터페이스에 일관된 디자인을 제공하기 위해
 * 색상과 폰트를 정의하고, 각 구성 요소의 스타일을 설정하는 메서드를 포함합니다.
 */
public class Design_forGui {
    // 색상 및 폰트 관련 변수들
    private final Color operatorColor = new Color(227, 148, 55); // 연산자 버튼 색상
    private final Color backgroundColor = new Color(0, 0, 0); // 배경 색상
    private final Color controlColor = new Color(165, 165, 165); // 제어 버튼 색상 (예: C, ±, %)
    private final Color numBtnColor = new Color(50, 50, 50); // 숫자 버튼 색상

    private final Font buttonFont = new Font("Dialog", Font.BOLD, 20); // 버튼 폰트 설정
    private final Font labelFont = new Font("Dialog", Font.PLAIN, 40); // 입력 표시 폰트 설정

    /**
     * 배경 색상을 반환합니다.
     *
     * @return backgroundColor, 배경 색상
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 연산자 버튼 색상을 반환합니다.
     *
     * @return operatorColor, 연산자 버튼 색상
     */
    public Color getOperatorColor() {
        return operatorColor;
    }

    /**
     * 제어 버튼 색상을 반환합니다.
     *
     * @return controlColor, 제어 버튼 색상
     */
    public Color getFunctionColor() {
        return controlColor;
    }

    /**
     * 숫자 버튼 색상을 반환합니다.
     *
     * @return numBtnColor, 숫자 버튼 색상
     */
    public Color getNumberColor() {
        return numBtnColor;
    }

    /**
     * 버튼에 사용할 폰트를 반환합니다.
     *
     * @return buttonFont, 버튼 폰트
     */
    public Font getButtonFont() {
        return buttonFont;
    }

    /**
     * 입력 표시창에 사용할 폰트를 반환합니다.
     *
     * @return labelFont, 입력 표시 폰트
     */
    public Font getLabelFont() {
        return labelFont;
    }

    /**
     * JButton의 스타일을 설정합니다. 버튼의 텍스트에 따라
     * 색상을 설정하며, 버튼의 폰트와 텍스트 색상을 지정합니다.
     *
     * @param button 스타일을 적용할 JButton
     * @param text 버튼에 표시할 텍스트
     */
    public void styleButton(JButton button, String text) {
        button.setFont(buttonFont);
        button.setForeground(Color.white);

        if (text.matches("[÷×\\-+=]")) {
            button.setBackground(operatorColor);
        } else if (text.matches("^(C|±|%)$")) {
            button.setBackground(controlColor);
        } else {
            button.setBackground(numBtnColor);
        }

        button.setOpaque(true);
    }

    /**
     * 입력 공간의 스타일을 설정합니다. 배경 색상, 폰트, 텍스트 정렬 및
     * 편집 가능 여부를 설정합니다.
     *
     * @param inputSpace 스타일을 적용할 JTextField
     */
    public void styleInputSpace(JTextField inputSpace) {
        inputSpace.setEditable(false);
        inputSpace.setBackground(backgroundColor);
        inputSpace.setHorizontalAlignment(JTextField.RIGHT);
        inputSpace.setFont(labelFont);
        inputSpace.setForeground(Color.white);
    }
}
