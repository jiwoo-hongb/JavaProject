package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * {@code RoundBtn} RoundBtn 클래스는 둥근 모서리를 가진 버튼을 생성하는 JButton 확장 클래스
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-10-15
 * @lastModified 2024-11-01
 *
 *            <ul>
 *            <li>2024-10-22: RoundBtn클래스 최초 생성</li><br>
 *             @see <a href="https://leirbag.tistory.com/15">둥근 버튼 구현</a>
 *             @see <a href="https://the-illusionist.me/42">둥근 버튼 구현2</a>
 */

public class RoundBtn extends JButton {
    /**
     * <li>paintComponent 메서드는 버튼의 상태에 따라 배경색을 변경하고, 둥근 모서리를 가진 버튼을 그리는 커스텀 페인팅을 수행</li>
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
     * <li>기본 생성자로, RoundBtn 인스턴스를 생성하고 초기 스타일을 적용</li>
     *
     */
    public RoundBtn() {
        super();
        decorate();
    }

    /**
     * <li>텍스트를 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용</li>
     *
     * @param text 버튼에 표시할 텍스트
     */
    public RoundBtn(String text) {
        super(text);
        decorate();
    }

    /**
     * <li>Action을 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용</li>
     *
     * @param action 버튼에 연결할 Action 객체
     */
    public RoundBtn(Action action) {
        super(action);
        decorate();
    }

    /**
     * <li>아이콘을 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용</li>
     *
     * @param icon 버튼에 표시할 Icon 객체
     */
    public RoundBtn(Icon icon) {
        super(icon);
        decorate();
    }

    /**
     * <li>텍스트와 아이콘을 설정하여 RoundBtn 인스턴스를 생성하고 초기 스타일을 적용</li>
     *
     * @param text 버튼에 표시할 텍스트
     * @param icon 버튼에 표시할 Icon 객체
     */
    public RoundBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    /**
     * <li>decorate 메서드는 RoundBtn의 초기 스타일을 설정</li>
     * <li>테두리 페인팅을 비활성화하고 배경을 투명하게 설정</li>
     */
    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }
}
