package gui;

import javax.swing.*;
import java.awt.*;

public class Main_Gui extends JFrame {
    JTextField textField;

    Main_Gui(){
        setTitle("계산기");

        setLayout(new BorderLayout());
        showNorth();
        showCenter();
        showSouth();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(335, 540);
        setVisible(true);
    }

    void showNorth(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("표준");

        panel.add(label);
        add(panel, BorderLayout.NORTH);
    }

    void showCenter(){
        JPanel panel = new JPanel();
        textField = new JTextField();

        panel.add(textField);
        add(panel, BorderLayout.CENTER);
    }


    void showSouth(){
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] cal_btn = {"CE", "C", "DEL", "÷", "7", "8", "9", "×", "4", "5", "6", "–", "1", "2", "3", "+", "±", "0", ".", "="};

        for(int i = 0; i < 20; i++){
            JButton btn = new JButton(cal_btn[i]);
            panel.add(btn);
        }
        add(panel, BorderLayout.SOUTH);
    }



    public static void main(String[] args) {
        new Main_Gui();
    }
}
