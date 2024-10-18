package gui;

import javax.swing.*;
import java.awt.*;

/**
 *
// * @create
 * - 10.15: 첫 Main_Gui 클래스 생성
 * - 10.18: Main_Gui 프로토 타입 수정 / Javadocs 첫 생성
 */

public class Main_Gui extends JFrame {
    JPanel main_Panel = new JPanel(); //메인 패널
    JLabel result_Label = new JLabel();//결과값이 나올 곳
    GridBagConstraints gbc = new GridBagConstraints();

    Main_Gui(){
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

    void showNorth(){
        JPanel panelStandard = new JPanel(new BorderLayout());
        JLabel label = new JLabel("표준");

        panelStandard.add(label, BorderLayout.WEST);
        panelStandard.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        main_Panel.add(panelStandard, gbc);
    }

    void showCenter(){
        JPanel panelResult = new JPanel(new BorderLayout());
        result_Label = new JLabel("0");

        panelResult.add(result_Label, BorderLayout.EAST);
        panelResult.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        main_Panel.add(panelResult, gbc);
    }

    void showSouth(){
        JPanel panelBtn = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] cal_btn = {"AC", "CE", "←", "÷", "7", "8", "9", "×", "4", "5", "6", "–", "1", "2", "3", "+", "±", "0", ".", "="};

        for(int i = 0; i < 20; i++){
            JButton btn = new JButton(cal_btn[i]);
            panelBtn.add(btn);
        }
        panelBtn.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        main_Panel.add(panelBtn, gbc);
    }

    public static void main(String[] args) {
        new Main_Gui();
    }
}
