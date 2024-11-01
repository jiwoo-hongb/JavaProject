package gui;

import javax.swing.*;
import java.awt.*;

/**
 * {@code Design_forGui} 계산기 GUI에 사용할 색상과 폰트를 정의하고, 버튼과 입력 공간의 스타일을 설정하는 기능을 제공
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-10-22
 * @lastModified 2024-11-01
 *
 *            <ul>
 *            <li>2024-10-22: Design_forGui 클래스 최초 생성</li>
 *            <li>2024-10-22: Main_Gui클래스에서 디자인 부분만 따로 분리하여 클래스 생성</li>
 *            <li>2024-10-22: 버튼, 패널 색상 수정</li>
 *            <li>2024-10-22: 버튼 모형 수정</li>
 *
 *            <header>[기능 전면 수정 도입]</header><br><br>
 *            <li>2024-10-30: 기능 전면 수정과 동시에 디자인 수정 도입</li>
 *            <li>2024-10-30: 버튼 디자인 수정"</li>
 *            <li>2024-10-30: 1번 수정사항에 따른 디자인 세부사항관련 코드 수정</li><br>
 *
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
     * <li>배경 색상을 반환</li>
     *
     * @return backgroundColor, 배경 색상
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * <li>연산자 버튼 색상을 반환</li>
     *
     * @return operatorColor, 연산자 버튼 색상
     */
    public Color getOperatorColor() {
        return operatorColor;
    }

    /**
     * <li>제어 버튼 색상을 반환</li>
     *
     * @return controlColor, 제어 버튼 색상
     */
    public Color getFunctionColor() {
        return controlColor;
    }

    /**
     * <li>숫자 버튼 색상을 반환</li>
     *
     * @return numBtnColor, 숫자 버튼 색상
     */
    public Color getNumberColor() {
        return numBtnColor;
    }

    /**
     * <li>버튼에 사용할 폰트를 반환</li>
     *
     * @return buttonFont, 버튼 폰트
     */
    public Font getButtonFont() {
        return buttonFont;
    }

    /**
     * <li>입력 표시창에 사용할 폰트를 반환</li>
     *
     * @return labelFont, 입력 표시 폰트
     */
    public Font getLabelFont() {
        return labelFont;
    }

    /**
     * <li>[JButton의 스타일을 설정]<li>
     * <li>버튼의 텍스트에 따라 색상을 설정하며, 버튼의 폰트와 텍스트 색상을 지정</li>
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
     * <li>[입력 공간의 스타일을 설정]<li>
     *<li>배경 색상, 폰트, 텍스트 정렬 및 편집 가능 여부를 설정</li>
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
