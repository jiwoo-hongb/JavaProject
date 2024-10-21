package gui;

import javax.swing.*;
import java.awt.*;

public class Design_forGui {
    // 색상 및 폰트 관련 변수들
    private final Color darkColor = new Color(80, 82, 85);
    private final Color operatorColor = new Color(255, 159, 9);
    private final Color functionColor = new Color(97, 99, 102);
    private final Color numberColor = new Color(123, 125, 127);

    private final Font buttonFont = new Font("Dialog", Font.BOLD, 20);
    private final Font labelFont = new Font("Dialog", Font.PLAIN, 40);

    // 색상 가져오기
    public Color getDarkColor() {
        return darkColor;
    }

    public Color getOperatorColor() {
        return operatorColor;
    }

    public Color getFunctionColor() {
        return functionColor;
    }

    public Color getNumberColor() {
        return numberColor;
    }

    // 폰트 가져오기
    public Font getButtonFont() {
        return buttonFont;
    }

    public Font getLabelFont() {
        return labelFont;
    }

    // 버튼 디자인 설정
    public void styleButton(JButton button, String text) {
        button.setFont(buttonFont);
        button.setForeground(Color.white);

        if (text.matches("[÷×–+=]")) {
            button.setBackground(operatorColor);
        } else if (text.matches("[ACCE←±]")) {
            button.setBackground(functionColor);
        } else {
            button.setBackground(numberColor);
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
