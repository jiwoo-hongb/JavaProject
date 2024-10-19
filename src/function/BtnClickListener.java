package function;
/**
 * - 10.19: 첫 BtnClickListener 클래스 생성
 */

/**
 * Main_Gui클래스로부터 ButtonEvent 제공
 * Click 이벤트시 cmd에 결과 출력
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BtnClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand(); // 버튼 텍스트 가져오기
        System.out.println(cmd);
    }
}
