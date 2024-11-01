package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import function.ButtonAction; // ButtonAction 클래스를 import
/**
 * {@code Calculate} 계산기 GUI를 설정하며 계산기의 UI와 버튼의 Action 코드를 불러와 실행시키는 클래스
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-10-15
 * @lastModified 2024-11-01
 *
 *            <ul>
 *            <li>2024-10-15: Main_GUI클래스 최초 생성</li><br>
 *
 *            <li>2024-10-18: 계산기 종류 라벨 위치 수정</li>
 *            <li>2024-10-18: 결과값 라벨 수정 "JTextField -> JLabel"</li>
 *            <li>2024-10-18:  버튼 위치 수정</li>
 *            <li>2024-10-18: 프레임 레이아웃 수정 및 패널 여백 설정</li><br>
 *
 *            <li>2024-10-19: BtnClickListener 호출 추가</li>
 *            <li>2024-10-19: 버튼 클릭시 콘솔창으로 숫자 입력받기까지는 완료</li><br>
 *
 *            <li>2024-10-20: Main_Gui클래스에서 수식 입력받는 곳과 계산결과 출력하는 곳 분리 =>
 * textPanel 추가</li><br>
 *
 *            <li>2024-10-22: Main_Gui클래스의 디자인 부분만 따로 분리</li><br>
 *
 *            <header>[기능 전면 수정 도입]</header><br><br>
 *            <li>2024-10-30: solution_Label, result_Label 디자인, 폰트 수정</li>
 *            <li>2024-10-30: 수정된 각 클래스에 맞게 코드 수정 진행</li><br>
 *
 *            <li>2024-10-31: 수정된 각 클래스에 맞게 코드 수정 진행</li>
 *            <li>2024-10-31: Javadoc 작성</li><br>
 *
 *            <li>2024-11-01: Javadoc 수정 완료</li>
 *            </ul>
 */

public class Main_Gui extends JFrame {
    private final int width = 240;
    private final int height = 370;
    private JTextField inputSpace = new JTextField();
    private String[] buttonNames = {"C", "±", "%", "÷", "7", "8", "9", "×", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "="};
    private RoundBtn[] buttons = new RoundBtn[buttonNames.length]; // RoundBtn 배열로 변경
    private Design_forGui design = new Design_forGui();

    /**
     * <li>{@code Main_Gui} 클래스는 계산기의 그래픽 사용자 인터페이스(GUI)를 설정하고 사용자가 입력 및 계산을 수행할 수 있도록 기능 제공</li>
     * <li>입력 표시창, 버튼 및 계산기 디자인 요소를 포함하며, 각 버튼의 액션을 {@link ButtonAction} 클래스에 위임함</li>
     * <li>계산기의 기본 레이아웃은 {@link GridBagLayout}을 사용</li>
     * <li>@link RoundBtn} 클래스는 각 버튼의 모양을 둥글게 만들어 사용자에게 친숙한 디자인 제공</li>
     * <li>{@link Design_forGui} 클래스는 전체적인 GUI 스타일(색상, 폰트 등)을 관리</li>
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
     * <li>지정된 제약 조건을 사용하여 구성 요소를 특정 패널에 추가</li>
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
     * <li>입력 및 출력을 표시하는 JTextField를 반환</li>
     *
     * @return inputSpace, 입력 표시 JTextField
     */
    public JTextField getInputSpace() {
        return inputSpace;
    }

    /**
     * <li>계산기 버튼 배열을 반환</li>
     *
     * @return buttons, RoundBtn 객체로 이루어진 배열
     */
    public RoundBtn[] getButtons() {
        return buttons;
    }

    /**
     * <li>모든 계산기 버튼에 ActionListener를 추가</li>
     *
     * @param listener 각 버튼에 연결할 ActionListener
     */
    public void addActionListener(ActionListener listener) {
        for (RoundBtn button : buttons) {
            button.addActionListener(listener);
        }
    }

    /**
     * <li>main 메서드는 Main_Gui 클래스를 인스턴스화하여 계산기 창을 초기화하고 표시</li>
     *
     * @param args 커맨드라인 인수 (사용되지 않음)
     */
    public static void main(String[] args) {
        new Main_Gui();
    }
}
