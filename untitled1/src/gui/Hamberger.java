package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        JButton orderButton[] = new JButton[menu.length];
        TextField suja[] = new TextField[menu.length];
        Label l[] = new Label[menu.length];
        Label menuLabel[] = new Label[menu.length];

        // 버튼 설정 부분
        for (int i = 0; i < menu.length; i++) {

            // 햄버거 메뉴 텍스트
            menuLabel[i] = new Label(menu[i]);
            if (i < 4) {
                menuLabel[i].setBounds(25 + i * 150, 50, 100, 30);
            } else {
                menuLabel[i].setBounds(25 + (i - 4) * 150, 300, 100, 30);
            }

            // 숫자 txt 버튼
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setVisible(false);
            suja[i].setBounds(menuLabel[i].getX() + 30, menuLabel[i].getY() + 65, 40, 20);

            // 가격 버튼
            l[i] = new Label(price[i] + "원");
            l[i].setBounds(menuLabel[i].getX() + 10, suja[i].getY() + 5, 100, 20);

            // 주문 버튼
            orderButton[i] = new JButton("주문");
            orderButton[i].setBounds(menuLabel[i].getX(), suja[i].getY() + 30, 100, 30);

            pNorth.add(menuLabel[i]);
            pNorth.add(suja[i]);
            pNorth.add(l[i]);
            pNorth.add(orderButton[i]);
        }

        // 중앙
        JPanel orderCartContainer = new JPanel(new BorderLayout());

        JPanel orderContainer = new JPanel();
        JLabel orderTitleLabel = new JLabel("주문 내역");
        JLabel quantityTitleLabel = new JLabel("수량(개)");
        JLabel quantityLabel = new JLabel("6");
        JLabel totalPriceTitleLabel = new JLabel("금액(원)");
        JLabel totalPriceLabel = new JLabel("44,500");
        Button allOrderCancelBtn = new Button("전체 취소");
        orderContainer.add(orderTitleLabel);
        orderContainer.add(quantityTitleLabel);
        orderContainer.add(quantityLabel);
        orderContainer.add(totalPriceTitleLabel);
        orderContainer.add(totalPriceLabel);
        orderContainer.add(allOrderCancelBtn);

        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setText("   상품명        단가        수량        합계\n\n");
        ta.setBackground(Color.white);
        ta.setEditable(false);
        ta.setFont(font1);

        orderCartContainer.add("North", orderContainer);
        orderCartContainer.add("Center", ta);

        // 남쪽
        Panel bottomContainer = new Panel(new BorderLayout());
        Panel cartMenuContainer = new Panel();
        bottomContainer.add(cartMenuContainer);

        cartMenuContainer.setFont(font);
        cartMenuContainer.setBackground(new Color(255, 255, 215));

        Button paymentBtn = new Button("결제");
        Button couponBtn = new Button("쿠폰");
        cartMenuContainer.add(paymentBtn);
        cartMenuContainer.add(couponBtn);

        // 결제 버튼 -> orderCompleteFrame 창 전환
        paymentBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new OrderConfirmationFrame();
                frame.setVisible(false); // 창 안보이게 하기
            }
        });

        couponBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScanCouponFrame();
                frame.setVisible(false); // 창 안보이게 하기
            }
        });

        // 전체 취소 버튼
        allOrderCancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.length; i++) {
                    if (selected[i]) {
                        selected[i] = false;
                        suja[i].setText("0");
                    }
                }
                ta.setText("   상품명        단가        수량        합계\n\n");
            }
        });

        JPanel HWContainer = new JPanel();
        HWContainer.setLayout(new GridLayout(2, 2)); // Set GridLayout with 2 rows and 1 column

        JPanel receiptPanel = new JPanel();

        JLabel receiptLabel = new JLabel("영수증 나오는 곳"); // Set the text for the label
        receiptPanel.add(receiptLabel);
        JButton cardBtn=new JButton("카드 리더기");
        HWContainer.add(receiptPanel);
        HWContainer.add(cardBtn);

        JButton barcodeBtn = new JButton("바코드 인식");
        HWContainer.add(new JPanel());
        HWContainer.add(barcodeBtn);
        HWContainer.add(barcodeBtn);
        bottomContainer.add("South",HWContainer);

        // 컴포넌트
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(orderCartContainer, BorderLayout.CENTER);
        frame.add(bottomContainer, BorderLayout.SOUTH);
        frame.setVisible(true);

        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            int j = i;

            orderButton[i].addActionListener(new ActionListener() {
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
