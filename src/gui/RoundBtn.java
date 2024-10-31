/**
 * RoundBtn 클래스는 둥근 모서리를 가진 버튼을 생성하는 JButton 확장 클래스입니다.
 * 버튼 클릭, 롤오버 등 상태에 따라 배경색을 변경하며, 커스텀 모양과 텍스트 중앙 정렬을 적용합니다.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * RoundBtn 클래스는 둥근 모서리를 가진 커스텀 JButton을 구현하며,
 * 버튼의 상태에 따라 배경색을 조정하고 텍스트를 중앙에 표시합니다.
 */
public class RoundBtn extends JButton {
    /**
     * paintComponent 메서드는 버튼의 상태에 따라 배경색을 변경하고,
     * 둥근 모서리를 가진 버튼을 그리는 커스텀 페인팅을 수행합니다.
     *
     * @param g 버튼의 페인팅에 사용할 Graphics 객체
     */
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        // 안티앨리어싱 설정
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 버튼 상태에 따른 배경색 설정
        if (getModel().isArmed()) {
            graphics.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(getBackground().brighter());
        } else {
            graphics.setColor(getBackground());
        }

        // 둥근 모서리를 가진 사각형으로 버튼 배경 채우기
        graphics.fillRoundRect(0, 0, width, height, 10, 10);

        // 텍스트 중앙 정렬을 위한 위치 계산
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        // 텍스트 색상 및 폰트 설정 후 그리기
        graphics.setColor(getForeground());
        graphics.setFont(getFont());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();

        super.paintComponent(g);
    }

    /**
     * 기본 생성자로, RoundBtn 인스턴스를 생성하고 초기 스타일을 적용합니다.
     */
    public RoundBtn() {
        super();
        decorate();
    }

    /**
     * 텍스트를 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용합니다.
     *
     * @param text 버튼에 표시할 텍스트
     */
    public RoundBtn(String text) {
        super(text);
        decorate();
    }

    /**
     * Action을 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용합니다.
     *
     * @param action 버튼에 연결할 Action 객체
     */
    public RoundBtn(Action action) {
        super(action);
        decorate();
    }

    /**
     * 아이콘을 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용합니다.
     *
     * @param icon 버튼에 표시할 Icon 객체
     */
    public RoundBtn(Icon icon) {
        super(icon);
        decorate();
    }

    /**
     * 텍스트와 아이콘을 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용합니다.
     *
     * @param text 버튼에 표시할 텍스트
     * @param icon 버튼에 표시할 Icon 객체
     */
    public RoundBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    /**
     * decorate 메서드는 RoundBtn의 초기 스타일을 설정합니다.
     * 테두리 페인팅을 비활성화하고 배경을 투명하게 설정합니다.
     */
    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }
}
