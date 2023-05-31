package burger;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Hamberger {
    int count = 0;
    String show = "";
    boolean selected[] = new boolean[8];

    public Hamberger() {

        // 디자인단
        // 프레임 설정단
        JFrame frame = new JFrame("햄버거 자동 판매기");
        frame.setBounds(0, 0, 625, 1000);
        frame.setBackground(Color.black);

        // 폰트
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

        // 북쪽
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(255, 255, 215));
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
        pNorth.setFont(font);

        // 배열 설정 부분
        String menu[] = { "빅맥버거", "싸이버거", "더블버거", "맘마버거", "김치버거", "새우버거", "라면버거", "치킨버거" };
        int price[] = { 5000, 5500, 6000, 6500, 7000, 7500, 8000, 8500 };
        JButton bt[] = new JButton[menu.length];
        TextField suja[] = new TextField[menu.length];
        Label l[] = new Label[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];

        // 버튼 설정 부분
        for (int i = 0; i < menu.length; i++) {

            // 햄버거 버튼
            bt[i] = new JButton(menu[i]);
            if (i < 4) {
                bt[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }
            icon[i] = new ImageIcon(i + ".png");
            bt[i].setIcon(icon[i]);

            // 숫자 txt 버튼
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);

            // 가격
            l[i] = new Label(price[i] + "원");
            l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);

            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(l[i]);
        }

        // 중앙
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명        단가        수량        합계\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);
        ta.setFont(font1);

        // 남쪽
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(255, 255, 215));

        Button bt1 = new Button("주문");
        Button bt2 = new Button("초기화");
        Button bt3 = new Button("닫기");
        pSouth.add(bt1);
        pSouth.add(bt2);
        pSouth.add(bt3);

        // 주문버튼
        bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
                for (int i = 0; i < menu.length; i++) {
                    if (selected[i]) {
                        selected[i] = false;
                        bt[i].setEnabled(true);
                        suja[i].setText("0");
                    }
                }
                ta.setText("   상품명        단가        수량        합계\n\n");
            }
        });

        // 초기화 버튼
        bt2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.length; i++) {
                    if (selected[i]) {
                        selected[i] = false;
                        bt[i].setEnabled(true);
                        suja[i].setText("0");
                    }
                }
                ta.setText("   상품명        단가        수량        합계\n\n");
            }
        });

        // 닫기 버튼
        bt3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // 컴포넌트
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(ta, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);

        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            int j = i;

            // 햄버그 버튼 이벤트
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int currentCount = Integer.parseInt(suja[j].getText());
                    currentCount++;
                    suja[j].setText(Integer.toString(currentCount));

                    ta.setText("   상품명        단가        수량        합계\n\n");
                    for (int k = 0; k < menu.length; k++) {
                        int count = Integer.parseInt(suja[k].getText());
                        if (count > 0) {
                            ta.append("   " + menu[k] + "       " + price[k] + "        " + count
                                    + "         " + price[k] * count + "원" + "\n");
                        }
                    }
                }
            });

        }

        // 끄기
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 메인
    public static void main(String[] args) {
        new Hamberger();
    }

}
