package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import function.ButtonAction; // ButtonAction 클래스를 import

/**
 * Main_Gui 클래스는 계산기 GUI를 설정하며, 입력 표시창과 버튼들을 초기화합니다.
 * 각 버튼에 대한 디자인 적용 및 레이아웃 구성을 담당합니다.
 */

public class Main_Gui extends JFrame {
    private final int width = 240;
    private final int height = 370;
    private JTextField inputSpace = new JTextField();
    private String[] buttonNames = {"C", "±", "%", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "="};
    private RoundBtn[] buttons = new RoundBtn[buttonNames.length]; // RoundBtn 배열로 변경
    private Design_forGui design = new Design_forGui();

    /**
     * Main_Gui 생성자는 계산기의 GUI 레이아웃과 구성 요소를 초기화합니다.
     * 입력 표시창과 버튼 패널을 설정하고, 각 버튼에 스타일을 적용합니다.
     */
    public Main_Gui() {
        setLayout(null);

        // 입력 표시창 설정
        design.styleInputSpace(inputSpace);
        inputSpace.setBounds(0, 0, width, 70);

        // GridBagLayout을 사용하는 버튼 패널 설정
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBounds(0, 70, width, 274);
        buttonPanel.setBackground(design.getBackgroundColor());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // 계산기 버튼을 버튼 패널에 추가
        int x = 0, y = 0;
        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new RoundBtn(buttonNames[i]);

            // 스타일 적용 및 버튼에 이벤트 리스너 추가
            design.styleButton(buttons[i], buttonNames[i]);
            buttons[i].addActionListener(new ButtonAction(inputSpace));

            // '0' 버튼에 대한 레이아웃 조정
            if (buttonNames[i].equals("0")) {
                addComponent(buttonPanel, buttons[i], x, y, 2, 1, gbc);
                x++;
            } else {
                addComponent(buttonPanel, buttons[i], x, y, 1, 1, gbc);
            }
            x++;
            if (x > 3) {
                x = 0;
                y++;
            }
        }

        // 메인 프레임에 구성 요소 추가
        add(inputSpace);
        add(buttonPanel);

        // JFrame 설정
        setTitle("계산기");
        setVisible(true);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 지정된 제약 조건을 사용하여 구성 요소를 특정 패널에 추가합니다.
     *
     * @param panel 구성 요소를 추가할 JPanel
     * @param comp 추가할 Component
     * @param x 그리드의 x 위치
     * @param y 그리드의 y 위치
     * @param width 그리드 셀 단위의 너비
     * @param height 그리드 셀 단위의 높이
     * @param gbc GridBagConstraints를 사용하여 구성 요소의 레이아웃을 설정
     */
    private void addComponent(JPanel panel, Component comp, int x, int y, int width, int height, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        panel.add(comp, gbc);
    }

    /**
     * 입력 및 출력을 표시하는 JTextField를 반환합니다.
     *
     * @return inputSpace, 입력 표시 JTextField
     */
    public JTextField getInputSpace() {
        return inputSpace;
    }

    /**
     * 계산기 버튼 배열을 반환합니다.
     *
     * @return buttons, RoundBtn 객체로 이루어진 배열
     */
    public RoundBtn[] getButtons() {
        return buttons;
    }

    /**
     * 모든 계산기 버튼에 ActionListener를 추가합니다.
     *
     * @param listener 각 버튼에 연결할 ActionListener
     */
    public void addActionListener(ActionListener listener) {
        for (RoundBtn button : buttons) {
            button.addActionListener(listener);
        }
    }

    /**
     * main 메서드는 Main_Gui 클래스를 인스턴스화하여 계산기 창을 초기화하고 표시합니다.
     *
     * @param args 커맨드라인 인수 (사용되지 않음)
     */
    public static void main(String[] args) {
        new Main_Gui();
    }
}
