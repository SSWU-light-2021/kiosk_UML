package gui;

import kiosk_class.Controller;
import kiosk_class.FoodMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel {


    Controller controllerObject = new Controller();

    public JFrame userPanelFrame = new JFrame("Hamburger Kiosk");

    public JPanel userPanelCenterContainer = new JPanel(new BorderLayout());

    // 메뉴
    public JPanel foodMenuContainer = new JPanel();
    public ImageIcon imageicon;
    public Image image;
    public JButton[] pic;
    public JLabel[] menuTitleLabel;
    public JLabel[] menuPriceLabel;
    public JButton[] pickBtn;

    // 주문
    public JPanel orderContainer = new JPanel();
    public JLabel orderTitleLabel = new JLabel("주문 내역"); // 주문 내역
    public JLabel quantityTitleLabel = new JLabel("수량(개)"); // 수량(개)
    public JLabel quantityLabel = new JLabel(); // 숫자
    public JLabel totalPriceTitleLabel = new JLabel("금액(원)"); // 금액(원)
    public JLabel totalPriceLabel = new JLabel(); // 숫자
    public JButton allOrderCancelBtn = new JButton("전체 취소");

    // 장바구니
    public TextArea cartMenuContainer = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);;

    // 결제
    public JPanel paymentContainer = new JPanel();
    public JButton paymentBtn = new JButton("결제");
    public JButton couponBtn = new JButton("쿠폰");

    // Order Confirmation Frame -----------------------------------------------------------
    public JFrame orderConfirmationFrame = new JFrame("Hamburger Kiosk <주문 확인>");
    public JLabel orderConfirmationTitleLabel = new JLabel("<주문 확인>");

    public JPanel orderConfirmationCenterContainer = new JPanel(new BorderLayout());

    // 주문 목록
    public JPanel orderListContainer = new JPanel(new GridLayout(0,3));
    public JLabel orderProductTitleLabel = new JLabel("주문 제품");
    public JLabel orderProductQuantityTitleLabel = new JLabel("수량");
    public JLabel orderProductAmountTitleLabel = new JLabel("금액");
    public JLabel orderProductLabel;
    public JLabel orderProductQuantityLabel;
    public JLabel orderProductAmountLabel;

    // 주문 금액
    public JPanel orderConfirmationContainer = new JPanel(new GridLayout(3,2));
    public JLabel orderAmountTitleLabel = new JLabel("주문 금액");
    public JLabel discountAmountTitleLabel = new JLabel("할인 금액");
    public JLabel totalPaymentAmountTitleLabel = new JLabel("총 결제 금액");
    public JLabel orderAmountLabel;
    public JLabel discountAmountLabel;
    public JLabel totalPaymentAmountLabel;

    public JPanel orderConfirmationBtnContainer = new JPanel();
    public JButton orderCancelBtn = new JButton("취소");
    public JButton finalpaymentBtn = new JButton("결제");

    // 결제 완료 Page
    public JPanel orderCompleteContainer;
    public JLabel orderCompleteTitleLabel;

    //쿠폰 스캔
    public JPanel scanCouponContainer;
    public JLabel scanCouponLabel;
    public JButton scanCouponOrderCancelBtn;

    // 카드삽입
    public JPanel insertCardContainer;
    public JLabel insertCardTitleLabel;
    public JLabel finalOrderAmountTitleLabel;
    public JLabel finalOrderAmountLabel;

    //승인여부
    public JPanel cardApprovalContainer;
    public JLabel approvalErrorTitleLabel;

    //결제완료. 영수증출력여부 묻기기
    public JPanel printReceiptContainer;
    public JLabel paymentCompleteTitleLabel;
    public JButton receiptYesBtn;
    public JButton receiptNoBtn;

    // 물리적인 장치
    public JPanel physicalPartsContainer = new JPanel(new GridLayout(2,2));
    public JLabel receiptLabel = new JLabel("영수증 나오는 곳");
    public JButton insertCardBtn = new JButton("카드 리더기");
    public JButton showBarcodeBtn = new JButton("바코드 인식");

    // 폰트
    public Font font_sans = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    public Font font_bold = new Font(Font.MONOSPACED, Font.BOLD, 22);

    // Main Page
    public void mainPage(FoodMenu[] menu, int menu_length) {
        // 프레임 설정
        userPanelFrame.setBounds(0, 0, 625, 1000);

        // North
        foodMenuContainer.setBackground(new Color(255, 255, 215));
        foodMenuContainer.setLayout(null);
        foodMenuContainer.setPreferredSize(new Dimension(600, 500));
        foodMenuContainer.setFont(font_sans);

        // 메뉴 관련 배열 설정
        menuTitleLabel = new JLabel[menu_length];
        pic = new JButton[menu_length];
        menuPriceLabel = new JLabel[menu_length];
        pickBtn = new JButton[menu_length];

        // 메뉴 설정
        for (int i = 0; i < menu_length; i++) {
            // 메뉴 이름
            menuTitleLabel[i] = new JLabel(menu[i].getName());
            if (i < 4) {
                menuTitleLabel[i].setBounds(25 + i * 150, 20, 100, 30);
            }
            else {
                menuTitleLabel[i].setBounds(25 + (i - 4) * 150, 250, 100, 30);
            }

            // 이미지
            pic[i] = new JButton(menu[i].getName());
            if (i < 4) {
                pic[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                pic[i].setBounds(25 + (i - 4) * 150, 250+30, 100, 100);
            }
            imageicon = new ImageIcon(Hamberger.class.getResource(menu[i].getImage()));
            image = imageicon.getImage().getScaledInstance(100,-1, Image.SCALE_SMOOTH);
            pic[i].setIcon(new ImageIcon(image));

            // 가격
            menuPriceLabel[i] = new JLabel(menu[i].getPrice()+"원");
            menuPriceLabel[i].setBounds(pic[i].getX() + 20, pic[i].getY() + 105, 100, 20);

            // pick 버튼
            pickBtn[i] = new JButton("담기");
            pickBtn[i].setBounds(menuTitleLabel[i].getX(), pic[i].getY() + 140, 100, 30);

            foodMenuContainer.add(menuTitleLabel[i]);
            foodMenuContainer.add(pic[i]);
            foodMenuContainer.add(menuPriceLabel[i]);
            foodMenuContainer.add(pickBtn[i]);
        }

        // Center
        // orderContainer
        // * quantityLabel, totalPriceLabel 설정해야 함
        orderContainer.add(orderTitleLabel);
        orderContainer.add(quantityTitleLabel);
        orderContainer.add(quantityLabel);
        orderContainer.add(totalPriceTitleLabel);
        orderContainer.add(totalPriceLabel);
        orderContainer.add(allOrderCancelBtn);

        // cartMenuContainer
        cartMenuContainer.setText("   상품명        단가        수량        합계\n\n");
        cartMenuContainer.setBackground(Color.white);
        cartMenuContainer.setEditable(false);
        cartMenuContainer.setFont(font_bold);

        // paymentContainer
        paymentContainer.setFont(font_sans);
        paymentContainer.setBackground(new Color(255, 255, 215));
        paymentContainer.add(paymentBtn);
        paymentContainer.add(couponBtn);

        // Center add
        userPanelCenterContainer.add("North", orderContainer);
        userPanelCenterContainer.add("Center", cartMenuContainer);
        userPanelCenterContainer.add("South", paymentContainer);

        // South
        physicalPartsContainer.add(receiptLabel);
        physicalPartsContainer.add(insertCardBtn);
        physicalPartsContainer.add(new JPanel());
        physicalPartsContainer.add(showBarcodeBtn);

        // 컴포넌트
        userPanelFrame.add("North",foodMenuContainer);
        userPanelFrame.add("Center",userPanelCenterContainer);
        userPanelFrame.add("South",physicalPartsContainer);

        userPanelFrame.setVisible(true);
        userPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료


        //eventListener
        // 결제 버튼 -> orderCompleteFrame 창 전환
        paymentBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(paymentBtn);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });

        //담기버튼
        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            int j = i;
            final int index =i;

            pickBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controllerObject.getCustomerInput(menu[index].getName(),menu[index].getPrice());
//                    int currentCount = Integer.parseInt(suja[j].getText());
//                    currentCount++;
//                    suja[j].setText(Integer.toString(currentCount));

//                    ta.setText("   상품명        단가        수량        합계\n\n");
//                    for (int k = 0; k < menu.length; k++) {
//                        int count = Integer.parseInt(suja[k].getText());
//                        if (count > 0) {
//                            ta.append("   " + menu[k] + "       " + price[k] + "        " + count
//                                    + "         " + price[k] * count + "원" + "\n");
//                        }
//                    }
                }

            });
        }
        // 카드 버튼
        insertCardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(insertCardBtn);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });


    }
    public void getBtnPress(JButton button){
        if (button.getText()=="결제"){
            controllerObject.accept(button);
        }
        else if (button.getText()=="카드"){
            controllerObject.accept(true);
        }
        else if (button.getText()=="기프티콘"){

        }
        else if (button.getText()=="예"){

        }
        else if (button.getText()=="아니오"){

        }
        else
            System.out.println("ㄴㄴㄴㄴ");
    }
    public void scan(int barcode){

    }
    public void displayPrompt(String text){
        if (text=="Over Limit" || text=="Expired" || text=="Card Not Read"|| text=="Take Card");
        JOptionPane.showMessageDialog(null, text, "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    // Order Confirmation Page
    public void orderConfirmationPage() {
        // 프레임 설정
        orderConfirmationFrame.setBounds(0, 0, 625, 1000);

        // North

        // Center
        // 주문 목록
        orderListContainer.setPreferredSize(new Dimension(400, 300));
        orderListContainer.setBackground(new Color(255, 255, 215));

        orderListContainer.add(orderProductTitleLabel);
        orderListContainer.add(orderProductQuantityTitleLabel);
        orderListContainer.add(orderProductAmountTitleLabel);

        // 주문 금액
        orderConfirmationContainer.add(orderAmountTitleLabel);
        orderConfirmationContainer.add(discountAmountTitleLabel);
        orderConfirmationContainer.add(totalPaymentAmountTitleLabel);

        // 버튼(결제, 취소)
        orderConfirmationBtnContainer.add(orderCancelBtn);
        orderConfirmationBtnContainer.add(finalpaymentBtn);

        orderConfirmationCenterContainer.add("North", orderListContainer);
        orderConfirmationCenterContainer.add("Center", orderConfirmationContainer);
        orderConfirmationCenterContainer.add("South", orderConfirmationBtnContainer);

        // South

        // 컴포넌트
        orderConfirmationFrame.add("North",orderConfirmationTitleLabel);
        orderConfirmationFrame.add("Center",orderConfirmationCenterContainer);
        orderConfirmationFrame.add("South",physicalPartsContainer);

        orderConfirmationFrame.setVisible(true);
        orderConfirmationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
    }


    public static void main(String[] args) {
        FoodMenu cheeseBurger = new FoodMenu("Burger", "치즈버거", "./image/1.jpeg", 5000);
        FoodMenu doubleBurger = new FoodMenu("Burger", "더블버거", "./image/2.jpeg", 6000);
        FoodMenu chickenBurger = new FoodMenu("Burger", "치킨버거", "./image/3.jpeg", 5500);
        FoodMenu coke = new FoodMenu("drink", "콜라", "./image/4.jpeg", 2500);
        FoodMenu potato = new FoodMenu("side", "감자튀김", "./image/5.jpeg", 1900);
        FoodMenu cheeseStick = new FoodMenu("side", "치즈스틱", "./image/6.jpeg", 2200);
        FoodMenu chocoIcecream = new FoodMenu("side", "초코 아이스크림", "./image/7.jpeg", 1500);
        FoodMenu vanilaIcecream = new FoodMenu("side", "바닐라 아이스크림", "./image/8.jpeg", 1500);
        FoodMenu menu[] = {cheeseBurger, doubleBurger, chickenBurger, coke, potato, cheeseStick, chocoIcecream, vanilaIcecream};

        UserPanel userPanel = new UserPanel();
        userPanel.mainPage(menu, menu.length);
        userPanel.orderConfirmationPage();
    }
}
