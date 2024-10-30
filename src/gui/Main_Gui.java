package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import function.ButtonAction; // ButtonAction 클래스를 import



public class Main_Gui extends JFrame {
    private final int width = 240;
    private final int height = 370;
    private JTextField inputSpace = new JTextField();
    private String[] buttonNames = {"C", "±", "%", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "="};
    private RoundBtn[] buttons = new RoundBtn[buttonNames.length]; // RoundBtn 배열로 변경
    private Design_forGui design = new Design_forGui();

    public Main_Gui() {
        setLayout(null);

        // 입력 공간 디자인 설정
        design.styleInputSpace(inputSpace); // 기존 `styleLabel`을 `styleInputSpace`로 변경하여 사용
        inputSpace.setBounds(0, 0, width, 70);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBounds(0, 70, width, 274);
        buttonPanel.setBackground(design.getBackgroundColor());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        int x = 0, y = 0;
        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new RoundBtn(buttonNames[i]); // RoundBtn 생성

            // 버튼 디자인 적용
            design.styleButton(buttons[i], buttonNames[i]);

            // ButtonAction을 사용하여 버튼 클릭 이벤트 추가
            buttons[i].addActionListener(new ButtonAction(inputSpace));


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

        add(inputSpace);
        add(buttonPanel);

        setTitle("게산기");
        setVisible(true);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent(JPanel panel, Component comp, int x, int y, int width, int height, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        panel.add(comp, gbc);
    }

    public JTextField getInputSpace() {
        return inputSpace;
    }

    public RoundBtn[] getButtons() {
        return buttons;
    }

    public void addActionListener(ActionListener listener) {
        for (RoundBtn button : buttons) {
            button.addActionListener(listener);
        }
    }

    public static void main(String[] args) {
        new Main_Gui();
    }
}
