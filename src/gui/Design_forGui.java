package gui;

import javax.swing.*;
import java.awt.*;

public class Design_forGui {
    // 색상 및 폰트 관련 변수들
    private final Color operatorColor = new Color(227, 148, 55);
    private final Color backgroundColor = new Color(0,0,0);
    private final Color controlColor = new Color(165, 165, 165);
    private final Color numBtnColor = new Color(50,50,50);

    private final Font buttonFont = new Font("Dialog", Font.BOLD, 20);
    private final Font labelFont = new Font("Dialog", Font.PLAIN, 40);

    // 색상 가져오기
    public Color getDarkColor() {
        return backgroundColor;
    }

    public Color getOperatorColor() {
        return operatorColor;
    }

    public Color getFunctionColor() {
        return controlColor;
    }

    public Color getNumberColor() {
        return numBtnColor;
    }

    // 폰트 가져오기
    public Font getButtonFont() {
        return buttonFont;
    }

    public Font getLabelFont() {
        return labelFont;
    }

    // 버튼 디자인 설정
    public void styleButton(RoundBtn button, String text) {
        button.setFont(buttonFont);
        button.setForeground(Color.white);

        if (text.matches("[÷×–+=]")) {
            button.setBackground(operatorColor);
        } else if (text.matches("^(AC|CE|←)$")) {
            button.setBackground(controlColor);
        } else {
            button.setBackground(numBtnColor);
        }

        button.setOpaque(true);
    }

    // 라벨 디자인 설정
    public void styleLabel(JLabel label) {
        label.setFont(labelFont);
        label.setHorizontalAlignment(SwingConstants.RIGHT); // 오른쪽 정렬
        label.setForeground(Color.WHITE);
    }
}
