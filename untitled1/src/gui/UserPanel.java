package gui;

import kiosk_class.CartMenu;
import kiosk_class.Controller;
import kiosk_class.FoodMenu;
import kiosk_class.Order;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel {
    // Main Page --------------------------------------------------------------------
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
    public JButton paymentBtn = new JButton("카드결제");
    public JButton couponBtn = new JButton("쿠폰");

    // Order Confirmation Page -----------------------------------------------------------
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
    public JButton orderCancelBtn = new JButton("취소"); //주문확인p
    public JButton finalpaymentBtn = new JButton("결제"); //주문확인p

    // Order Complete Page ------------------------------------------------
    public JFrame orderCompleteFrame = new JFrame("Hamburger Kiosk <주문 완료>");
    public JPanel orderCompleteContainer = new JPanel();
    public JLabel orderCompleteTitleLabel = new JLabel("주문 완료");

    // Insert Card Page ------------------------------------------------------------
    public JFrame insertCardFrame = new JFrame("Hamburger Kiosk <카드 삽입>");
    public JPanel insertCardContainer = new JPanel(new GridLayout(2,1));
    public JLabel insertCardTitleLabel = new JLabel("카드를 삽입해주세요.");
    public JPanel finalOrderAmountContainer = new JPanel();
    public JLabel finalOrderAmountTitleLabel = new JLabel("결제금액");
    public JLabel finalOrderAmountLabel;

    // 결제완료. 영수증출력여부 묻기기
    public JFrame isReceiptPrintFrame = new JFrame("Hamburger Kiosk <영수증>");
    public JPanel printReceiptContainer = new JPanel();
    public JLabel printReceiptTitleLabel = new JLabel("영수증을 출력하시겠습니까?");
    public JButton receiptYesBtn = new JButton("예");
    public JButton receiptNoBtn = new JButton("아니오");

    //쿠폰 스캔
    public JPanel scanCouponContainer;
    public JLabel scanCouponLabel;
    public JButton scanCouponOrderCancelBtn;

    //승인여부
    public JPanel cardApprovalContainer;
    public JLabel approvalErrorTitleLabel;

    // 물리적인 장치
    public JPanel physicalPartsContainer = new JPanel(new GridLayout(2,2));
    public JLabel receiptLabel = new JLabel("영수증 나오는 곳");
    public JButton insertCardBtn = new JButton("카드 리더기");
    public JButton showBarcodeBtn = new JButton("바코드 인식");

    // 폰트
    public Font font_sans = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    public Font font_bold = new Font(Font.MONOSPACED, Font.BOLD, 22);

    public UserPanel() {
        physicalPartsContainer.add(receiptLabel);
        physicalPartsContainer.add(insertCardBtn);
        physicalPartsContainer.add(new JPanel());
        physicalPartsContainer.add(showBarcodeBtn);
    }

    // Frame
    // Main Page
    public void mainPage(FoodMenu[] menu, int menu_length, CartMenu cart, Controller c, Order order, UserPanel up) {
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
            imageicon = new ImageIcon(UserPanel.class.getResource(menu[i].getImage()));
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
//        physicalPartsContainer.add(receiptLabel);
//        physicalPartsContainer.add(insertCardBtn);
//        physicalPartsContainer.add(new JPanel());
//        physicalPartsContainer.add(showBarcodeBtn);

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
                getBtnPress(paymentBtn, cart, c,order, up);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });
        insertCardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(insertCardBtn, cart, c,order, up);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });
        //담기버튼
        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            final int index =i;

            pickBtn[index].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int cartNum = c.getCustomerInput(menu[index].getName(),menu[index].getPrice(), cart, order, c);
                    System.out.println(cart.getMenuName()[cartNum]);
                    cartMenuContainer.append("   " + cart.getMenuName()[cartNum] + "       " + cart.getPrice()[cartNum] + "        "
                            + cart.getMenuQuantity()[cartNum] + "         " + cart.getTotalPricePerMenu()[cartNum] + "원" + "\n");
                }

            });
        }
        // 카드 버튼
        insertCardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(insertCardBtn, cart, c,order, up);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });


    }
    // Order Confirmation Page
    public void orderConfirmationPage(Controller c, CartMenu cart, Order order) {
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

        // 장바구니 값 가져오기
        for (int i = 0; i < cart.getNum(); i++) {
            orderProductLabel = new JLabel(cart.getMenuName()[i]); // 주문 제품
            orderProductQuantityLabel = new JLabel(Integer.toString(cart.getMenuQuantity()[i])); // 수량
            orderProductAmountLabel = new JLabel(Integer.toString(cart.getPrice()[i] * cart.getMenuQuantity()[i]));
            orderListContainer.add(orderProductLabel);
            orderListContainer.add(orderProductQuantityLabel);
            orderListContainer.add(orderProductAmountLabel);

        }

        // 주문 금액
        c.ACKorNot(cart, order);
        orderAmountLabel=new JLabel(Integer.toString(order.getTotalPrice()));
//        System.out.println(order.getTotalPrice());
        discountAmountLabel=new JLabel(Integer.toString(0));
        totalPaymentAmountLabel=new JLabel(Integer.toString(order.getTotalPrice()-1));
        orderConfirmationContainer.add(orderAmountTitleLabel);
        orderConfirmationContainer.add(orderAmountLabel);
        orderConfirmationContainer.add(discountAmountTitleLabel);
        orderConfirmationContainer.add(discountAmountLabel);
        orderConfirmationContainer.add(totalPaymentAmountTitleLabel);
        orderConfirmationContainer.add(totalPaymentAmountLabel);


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

    // Order Complete Page
    public void orderCompletePage() {
        orderCompleteFrame.setBounds(0, 0, 625, 1000);

        // Panel
        orderCompleteContainer.setBorder(new EmptyBorder(300, 0, 0, 0)); // Add top margin
        orderCompleteTitleLabel.setFont(font_bold);
        orderCompleteContainer.add(orderCompleteTitleLabel);

        // Frame 컴포넌트
        orderCompleteFrame.add("Center",orderCompleteContainer);
        orderCompleteFrame.setVisible(true);
        orderCompleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
    }

    // Insert Card Page
    public void insertCardPage() {
        insertCardFrame.setBounds(0, 0, 625, 1000);

        insertCardContainer.setBorder(new EmptyBorder(300, 0, 0, 0)); // Add top margin
        insertCardContainer.add(insertCardTitleLabel);

        finalOrderAmountContainer.add(finalOrderAmountTitleLabel);
//        finalOrderAmountContainer.add(finalOrderAmountLabel);
        insertCardContainer.add(finalOrderAmountContainer);

        insertCardFrame.add(insertCardContainer);
        insertCardFrame.setVisible(true);
        insertCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
    }

    // Is Receipt print Page
    public void isReceiptPrintPage() {
        isReceiptPrintFrame.setBounds(0, 0, 625, 1000);

//        printReceiptContainer.setBorder(new EmptyBorder(300, 0, 0, 0)); // Add top margin
        printReceiptContainer.add(receiptYesBtn);
        printReceiptContainer.add(receiptNoBtn);
        isReceiptPrintFrame.add("Center", printReceiptTitleLabel);
        isReceiptPrintFrame.add("South", printReceiptContainer);

        isReceiptPrintFrame.setVisible(true);
        isReceiptPrintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
    }

    // operation
    public void getBtnPress(JButton button, CartMenu cart, Controller c,Order order, UserPanel up){
        if (button.getText()=="카드결제") {

            c.accept(button, cart, order, up);
            userPanelFrame.setVisible(false);
        }
//            public void getBtnPress(JButton button){
//        if (button.getText()=="결제"){
//            Controller controllerObject = new Controller();
//            controllerObject.accept(button);
//        }

        else if (button.getText()=="카드"){
           c.accept(true,up);
        }
        else if (button.getText()=="기프티콘"){

        }
        else if (button.getText()=="예"){

        }
        else if (button.getText()=="아니오"){

        }
        else if (button.getText()=="카드 리더기"){
            if (cart.getNum()==0){// 카트에 물건 없음
                //
            }
            else
                c.accept(insertCardBtn, cart,order, up);
        }
        else
            System.out.println("");
    }
    public void scan(int barcode){

    }
    public void displayPrompt(String text){
        if (text=="overLimit" || text=="expired" || text=="Card Not Read"|| text=="Take Card")
           // JOptionPane.showMessageDialog(null, text, "알림", JOptionPane.INFORMATION_MESSAGE);
            ;
        else if (text=="영수증받말"){
            //영수증 받/말 선택화면
        }
    }

    public static void main(String[] args) { // 메인 함수
        FoodMenu cheeseBurger = new FoodMenu("Burger", "치즈버거", "./image/1.jpeg", 5000);
        FoodMenu doubleBurger = new FoodMenu("Burger", "더블버거", "./image/2.jpeg", 6000);
        FoodMenu chickenBurger = new FoodMenu("Burger", "치킨버거", "./image/3.jpeg", 5500);
        FoodMenu coke = new FoodMenu("drink", "콜라", "./image/4.jpeg", 2500);
        FoodMenu potato = new FoodMenu("side", "감자튀김", "./image/5.jpeg", 1900);
        FoodMenu cheeseStick = new FoodMenu("side", "치즈스틱", "./image/6.jpeg", 2200);
        FoodMenu chocoIcecream = new FoodMenu("side", "초코 아이스크림", "./image/7.jpeg", 1500);
        FoodMenu vanilaIcecream = new FoodMenu("side", "바닐라 아이스크림", "./image/8.jpeg", 1500);
        FoodMenu menu[] = {cheeseBurger, doubleBurger, chickenBurger, coke, potato, cheeseStick, chocoIcecream, vanilaIcecream};

        CartMenu cart=new CartMenu();
        Controller c = new Controller();
        Order order=new Order();
        UserPanel userPanel = new UserPanel();

        userPanel.mainPage(menu, menu.length, cart, c, order, userPanel);

        userPanel.orderCompletePage();
        userPanel.insertCardPage();
        userPanel.isReceiptPrintPage();
    }
}
