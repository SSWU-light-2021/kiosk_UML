package gui;

import kiosk_class.Controller;
import kiosk_class.FoodMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Hamberger {
    FoodMenu cheeseBurger = new FoodMenu("Burger", "치즈버거", "./image/1.jpeg", 5000);
    FoodMenu doubleBurger = new FoodMenu("Burger", "더블버거", "./image/2.jpeg", 6000);
    FoodMenu chickenBurger = new FoodMenu("Burger", "치킨버거", "./image/3.jpeg", 5500);
    FoodMenu coke = new FoodMenu("drink", "콜라", "./image/4.jpeg", 2500);
    FoodMenu potato = new FoodMenu("side", "감자튀김", "./image/5.jpeg", 1900);
    FoodMenu cheeseStick = new FoodMenu("side", "치즈스틱", "./image/6.jpeg", 2200);
    FoodMenu chocoIcecream = new FoodMenu("side", "초코 아이스크림", "./image/7.jpeg", 1500);
    FoodMenu vanilaIcecream = new FoodMenu("side", "바닐라 아이스크림", "./image/8.jpeg", 1500);
    Controller controllerObject = new Controller();
    boolean selected[] = new boolean[8];
    String menu[] = { cheeseBurger.getName(), doubleBurger.getName(), chickenBurger.getName(), coke.getName(), potato.getName(), cheeseStick.getName(), chocoIcecream.getName(), vanilaIcecream.getName() };
    int price[] = { cheeseBurger.getPrice(), doubleBurger.getPrice(), chickenBurger.getPrice(), coke.getPrice(), potato.getPrice(), cheeseStick.getPrice(), chocoIcecream.getPrice(), vanilaIcecream.getPrice() };
    String image[]={cheeseBurger.getImage(), doubleBurger.getImage(), chickenBurger.getImage(), coke.getImage(), potato.getImage(), cheeseStick.getImage(), chocoIcecream.getImage(), vanilaIcecream.getImage() };
    TextField suja[] = new TextField[menu.length];
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
        JButton pic[]=new JButton[menu.length];

        Label labels[] = new Label[menu.length];
        Label menuLabel[] = new Label[menu.length];
        JButton orderButton[] = new JButton[menu.length];

        ImageIcon icon[] = new ImageIcon[menu.length];

        // 버튼 설정 부분
        for (int i = 0; i < menu.length; i++) {
            menuLabel[i] = new Label(menu[i]);
            if (i < 4) {
                menuLabel[i].setBounds(25 + i * 150, 50, 100, 30);
            } else {
                menuLabel[i].setBounds(25 + (i - 4) * 150, 300, 100, 30);
            }

            // 햄버거 버튼
            pic[i] = new JButton(menu[i]);
            if (i < 4) {
                pic[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                pic[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }
            ImageIcon imageicon = new ImageIcon(Hamberger.class.getResource(image[i]));
            Image image = imageicon.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
            pic[i].setIcon(new ImageIcon(image));

            // 숫자 txt 버튼
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);
            suja[i].setVisible(false);
            suja[i].setBounds(pic[i].getX() + 30, pic[i].getY() + 130, 40, 20);

            // 가격 버튼
            labels[i] = new Label(price[i] + "원");
            labels[i].setBounds(pic[i].getX() + 20, suja[i].getY() - 25, 100, 20);
            // 주문 버튼
            orderButton[i] = new JButton("주문");
            orderButton[i].setBounds(menuLabel[i].getX(), suja[i].getY() + 30, 100, 30);
            pNorth.add(menuLabel[i]);
            pNorth.add(pic[i]);
            pNorth.add(suja[i]);
            pNorth.add(labels[i]);
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

        JButton paymentBtn = new JButton("결제");
        JButton couponBtn = new JButton("쿠폰");
        cartMenuContainer.add(paymentBtn);
        cartMenuContainer.add(couponBtn);

        // 결제 버튼 -> orderCompleteFrame 창 전환
        paymentBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(paymentBtn);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame(menu, suja, price);
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
                        pic[i].setEnabled(true);
                        suja[i].setText("0");
                    }
                }
                ta.setText("   상품명        단가        수량        합계\n\n");
            }
        });

        couponBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScanCouponFrame();
                frame.setVisible(false); // 창 안보이게 하기
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
        bottomContainer.add("South",HWContainer);

//
//                JLabel imgLbl = new JLabel();
//        // ★ 라벨에 넣을 아이콘 생성
//        ImageIcon bsImg = new ImageIcon(Hamberger.class.getResource("./image/1.jpeg"));
//        imgLbl.setIcon(bsImg);
//        HWContainer.add(imgLbl);

        // 컴포넌트
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(orderCartContainer, BorderLayout.CENTER);
        frame.add(bottomContainer, BorderLayout.SOUTH);
        frame.setVisible(true);
        Controller c = new Controller();
        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            int j = i;
            final int index =i;

            orderButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controllerObject.getCustomerInput(menu[index],price[index]);
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
    public void getBtnPress(JButton button){
        if (button.getText()=="결제"){
            controllerObject.accept(button);
        }
        else if (button.getText()=="카드"){

        }
        else if (button.getText()=="기프티콘"){

        }
        else if (button.getText()=="예"){

        }
        else if (button.getText()=="아니오"){

        }
    }
    public void scan(int barcode){

    }
    public void displayPrompt(String text){
        if (text=="Over Limit" || text=="Expired" || text=="Card Not Read"|| text=="Take Card");
        JOptionPane.showMessageDialog(null, text, "알림", JOptionPane.INFORMATION_MESSAGE);
    }
    // 메인
    public static void main(String[] args) {
        new Hamberger();

    }

}