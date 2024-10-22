package gui;

import function.BtnClickListener; // 버튼 입력 기능 가져오기

import javax.swing.*;
import java.awt.*;

public class Main_Gui extends JFrame {
    JPanel main_Panel = new JPanel(); //메인 패널
    JLabel solution_Label = new JLabel();
    JLabel result_Label = new JLabel(); // 결과값이 나올 곳
    GridBagConstraints gbc = new GridBagConstraints();
    Design_forGui design = new Design_forGui();

    Main_Gui() {
        setTitle("계산기");
        main_Panel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 1;
        gbc.weighty = 0.1;
        gbc.gridy = 0;
        showNorth();

        gbc.weightx = 1;
        gbc.weighty = 0.2;
        gbc.gridy = 1;
        showCenter();

        gbc.weightx = 1;
        gbc.weighty = 0.7;
        gbc.gridy = 2;
        showSouth();

        add(main_Panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(335, 540);
        setVisible(true);
    }

    void showNorth() {
        JPanel panelStandard = new JPanel(new BorderLayout());
        JLabel label = new JLabel("표준");

        panelStandard.add(label, BorderLayout.WEST);
        panelStandard.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        panelStandard.setBackground(design.getDarkColor());

        main_Panel.add(panelStandard, gbc);
    }

    void showCenter() {
        JPanel panelResult = new JPanel(new BorderLayout());
        JPanel textPanel = new JPanel(new GridBagLayout());

        solution_Label = new JLabel("0");
        result_Label = new JLabel("0");

        gbc.gridy = 0;
        textPanel.add(solution_Label, gbc);
        gbc.gridy = 1;
        textPanel.add(result_Label, gbc);

        panelResult.add(textPanel, BorderLayout.EAST);

        panelResult.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        panelResult.setBackground(design.getDarkColor());
        main_Panel.add(panelResult, gbc);
    }

    void showSouth() {
        JPanel panelBtn = new JPanel(new GridLayout(5, 4, 5, 5));
        panelBtn.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        panelBtn.setBackground(design.getDarkColor()); //

        String[] cal_btn = {"AC", "CE", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "–", "1", "2", "3", "+", "±", "0", ".", "="};

        BtnClickListener btnClickListener = new BtnClickListener(solution_Label, result_Label);

        for (int i = 0; i < 20; i++) {
            RoundBtn btn = new RoundBtn(cal_btn[i]);

            design.styleButton(btn, cal_btn[i]); //
            btn.addActionListener(btnClickListener);
            panelBtn.add(btn);
        }

        main_Panel.add(panelBtn, gbc);
    }

    public static void main(String[] args) {
        new Main_Gui();
    }
}
