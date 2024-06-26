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
    public JLabel quantityLabel; // 숫자
    public JLabel totalPriceTitleLabel = new JLabel("금액(원)"); // 금액(원)
    public JLabel totalPriceLabel ; // 숫자
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

    // Is Receipt print Page ------------------------------------------------------------
    public JFrame isReceiptPrintFrame = new JFrame("Hamburger Kiosk <영수증>");
    public JPanel printReceiptContainer = new JPanel(new GridLayout(2,2));
    public JLabel printReceiptTitleLabel = new JLabel("<html><body>카드 승인 완료<br />영수증을 출력하시겠습니까?</body></html>\"");
    public JButton receiptYesBtn = new JButton("예");
    public JButton receiptNoBtn = new JButton("아니오");
    public JButton receiptYesBtn2 = new JButton("예");
    public JButton receiptNoBtn2 = new JButton("아니오");
    // Approval Error Page ------------------------------------------------------------
    public JFrame approvalErrorFrame = new JFrame("Hamburger Kiosk <승인 오류>");
    public JPanel cardApprovalContainer = new JPanel();
    public JLabel approvalErrorTitleLabel = new JLabel("승인 오류");

    //쿠폰 스캔
    public JPanel scanCouponContainer;
    public JLabel scanCouponLabel;
    public JButton scanCouponOrderCancelBtn;


    public JPanel physicalPartsContainer = new JPanel(new GridLayout(2,2));
    public JLabel receiptLabel = new JLabel("영수증 나오는 곳");
    public JButton insertCardBtn = new JButton("카드 리더기");
    public JButton insertCardBtn2 = new JButton("카드 리더기");
    public JButton showBarcodeBtn = new JButton("바코드 인식");

    public UserPanel() {
        physicalPartsContainer.add(receiptLabel);
        physicalPartsContainer.add(insertCardBtn);
        physicalPartsContainer.add(insertCardBtn);
        physicalPartsContainer.add(showBarcodeBtn);
    }
    // 폰트
    public Font font_sans = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    public Font font_bold = new Font(Font.MONOSPACED, Font.BOLD, 22);

    // Page
    // Main Page
    public void mainPage(FoodMenu[] menu, int menu_length, CartMenu cart, Controller c, Order order) {
        // 물리적인 장치



        // 프레임 설정
        userPanelFrame.setBounds(0, 0, 625, 1000);

        // North
        foodMenuContainer.setBackground(new Color(245,218,223));
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
        int num=0;
        int price=0;

        quantityLabel=new JLabel(Integer.toString(num));
        totalPriceLabel=new JLabel(Integer.toString(price));
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
        paymentContainer.setBackground(new Color(245,218,223));
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
                getBtnPress(paymentBtn, cart, c,order, UserPanel.this);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });
        couponBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(couponBtn, cart, c,order, UserPanel.this);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });
        insertCardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(insertCardBtn, cart, c,order, UserPanel.this);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });
        showBarcodeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(showBarcodeBtn, cart, c,order, UserPanel.this);
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
                    int cartNum = c.getCustomerInput(menu[index].getName(), menu[index].getPrice(), index, cart, order, c);
                    int num = 0;
                    int price = 0;
                    for (int i = 0; i < 10; i++) {
                        num += cart.getMenuQuantity()[i];
                        price += cart.getTotalPricePerMenu()[i];
                    }

                    quantityLabel.setText(Integer.toString(num)); // 수량 라벨의 값을 갱신
                    totalPriceLabel.setText(Integer.toString(price)); // 총 가격 라벨의 값을 갱신
                    cartMenuContainer.setText("   상품명        단가        수량        합계\n\n");

                    for (int i = 0; i < cart.getMenuName().length; i++) {
                        if (cart.getMenuName()[i] != null) {
                            cartMenuContainer.append("   " + cart.getMenuName()[i] + "       " + cart.getPrice()[i] + "        "
                                    + cart.getMenuQuantity()[i] + "         " + cart.getTotalPricePerMenu()[i] + "원" + "\n");
                        }
                    }

                    // 컨테이너를 갱신하여 변경된 라벨과 내용을 반영합니다.
                    userPanelFrame.revalidate();
                    userPanelFrame.repaint();
                }



            });
        }

        // 카드 버튼
        insertCardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("설마?");
                getBtnPress(insertCardBtn, cart, c,order, UserPanel.this);
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
        orderListContainer.setBackground(new Color(245,218,223));

        orderListContainer.add(orderProductTitleLabel);
        orderListContainer.add(orderProductQuantityTitleLabel);
        orderListContainer.add(orderProductAmountTitleLabel);

        // 장바구니 값 가져오기
        for (int i = 0; i < 10; i++) {
            if (cart.getMenuQuantity()[i]!=0){
                orderProductLabel = new JLabel(cart.getMenuName()[i]); // 주문 제품
                orderProductQuantityLabel = new JLabel(Integer.toString(cart.getMenuQuantity()[i])); // 수량
                orderProductAmountLabel = new JLabel(Integer.toString(cart.getPrice()[i] * cart.getMenuQuantity()[i]));

                orderListContainer.add(orderProductLabel);
                orderListContainer.add(orderProductQuantityLabel);
                orderListContainer.add(orderProductAmountLabel);
            }
        }

        // 주문 금액
        c.ACKorNot(cart, order);
        orderAmountLabel=new JLabel(Integer.toString(order.getTotalPrice()));
//        System.out.println(order.getTotalPrice());
        discountAmountLabel=new JLabel(Integer.toString(0));
        totalPaymentAmountLabel=new JLabel(Integer.toString(order.getTotalPrice()));
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
    public void orderConfirmationPage(Controller c, CartMenu cart, Order order, int barcodePrice) {
        // 프레임 설정

        //
        orderConfirmationFrame.setBounds(0, 0, 625, 1000);
        // North

        // Center
        // 주문 목록
        orderListContainer.setPreferredSize(new Dimension(400, 300));
        orderListContainer.setBackground(new Color(245,218,223));

        orderListContainer.add(orderProductTitleLabel);
        orderListContainer.add(orderProductQuantityTitleLabel);
        orderListContainer.add(orderProductAmountTitleLabel);

        // 장바구니 값 가져오기
        for (int i = 0; i < 10; i++) {
            if (cart.getMenuQuantity()[i]!=0){
                orderProductLabel = new JLabel(cart.getMenuName()[i]); // 주문 제품
                orderProductQuantityLabel = new JLabel(Integer.toString(cart.getMenuQuantity()[i])); // 수량
                orderProductAmountLabel = new JLabel(Integer.toString(cart.getPrice()[i] * cart.getMenuQuantity()[i]));

                orderListContainer.add(orderProductLabel);
                orderListContainer.add(orderProductQuantityLabel);
                orderListContainer.add(orderProductAmountLabel);
            }
        }

        // 주문 금액
        c.ACKorNot(cart, order);
        orderAmountLabel=new JLabel(Integer.toString(order.getTotalPrice()));
//        System.out.println(order.getTotalPrice());
        discountAmountLabel=new JLabel(Integer.toString(barcodePrice));
        totalPaymentAmountLabel=new JLabel(Integer.toString(order.getTotalPrice()-barcodePrice));
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

//        insertCardBtn.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) { //여기진짜이상함..어떻게해야할지모르겟음..
//                getBtnPress_barcode(insertCardBtn, cart, c,order, UserPanel.this,5000);
////                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
////                userPanelFrame.setVisible(false); // 창 안보이게 하기
//            }
//        });
        insertCardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { //여기진짜이상함..어떻게해야할지모르겟음..
                getBtnPress_barcode(insertCardBtn, cart, c,order, UserPanel.this,barcodePrice);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });


    }
    // Order Complete Page
    public void orderCompletePage() {
        orderCompleteFrame.setBounds(0, 0, 625, 1000);

        // Panel
        orderCompleteContainer.setBorder(new EmptyBorder(400, 0, 0, 0)); // Add top margin
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

        insertCardContainer.setBorder(new EmptyBorder(300, 260, 0, 0)); // Add top margin
        insertCardContainer.add(insertCardTitleLabel);

        insertCardFrame.add("Center", insertCardContainer);
        insertCardFrame.add("South", physicalPartsContainer);
        insertCardFrame.setVisible(true);
        insertCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
    }

    // Is Receipt print Page
    public void isReceiptPrintPage(Controller c, CartMenu cart, Order order,UserPanel up) {
        isReceiptPrintFrame.setBounds(0, 0, 625, 1000);

        printReceiptContainer.setBorder(new EmptyBorder(350, 100, 500, 100)); // Add top margin
        printReceiptContainer.add(printReceiptTitleLabel);
        printReceiptContainer.add(new JPanel());
        printReceiptContainer.add(receiptYesBtn);
        printReceiptContainer.add(receiptNoBtn);
//        isReceiptPrintFrame.add("North", printReceiptTitleLabel);
        isReceiptPrintFrame.add("Center", printReceiptContainer);
        isReceiptPrintFrame.add("South", physicalPartsContainer);

        isReceiptPrintFrame.setVisible(true);
        isReceiptPrintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료

        receiptYesBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                getBtnPress(receiptYesBtn, cart, c,order, up);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });
        receiptNoBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(receiptNoBtn, cart, c,order, up);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });

    }
    public void isReceiptPrintPage_barcode(Controller c, CartMenu cart, Order order,UserPanel up, int barcodePrice) {
        isReceiptPrintFrame.setBounds(0, 0, 625, 1000);

        printReceiptContainer.setBorder(new EmptyBorder(350, 100, 500, 100)); // Add top margin
        JLabel printReceiptTitleLabel2 = new JLabel("<html><body>바코드 승인 완료<br />영수증을 출력하시겠습니까?</body></html>\"");

        printReceiptContainer.add(printReceiptTitleLabel2);
        printReceiptContainer.add(new JPanel());
        printReceiptContainer.add(receiptYesBtn2);
        printReceiptContainer.add(receiptNoBtn2);
//        isReceiptPrintFrame.add("North", printReceiptTitleLabel);
        isReceiptPrintFrame.add("Center", printReceiptContainer);
        isReceiptPrintFrame.add("South", physicalPartsContainer);

        isReceiptPrintFrame.setVisible(true);
        isReceiptPrintFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료

        receiptYesBtn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress_barcode(receiptYesBtn2, cart, c,order, up, barcodePrice);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });
        receiptNoBtn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getBtnPress(receiptNoBtn2, cart, c,order, up);
//                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
//                userPanelFrame.setVisible(false); // 창 안보이게 하기
            }
        });

    }
    // Approval Error Page
    public void approvalErrorPage(String text) {
        approvalErrorFrame.setBounds(0, 0, 625, 1000);

        cardApprovalContainer.setBorder(new EmptyBorder(350, 100, 500, 100)); // Add top margin
        approvalErrorTitleLabel.setFont(font_bold);
        cardApprovalContainer.add(approvalErrorTitleLabel);

        JLabel ll=new JLabel(text);
        cardApprovalContainer.add(ll);
        approvalErrorFrame.add(cardApprovalContainer);

        approvalErrorFrame.setVisible(true);
        approvalErrorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
    }

    public void getBtnPress_barcode(JButton button, CartMenu cart, Controller c,Order order, UserPanel up, int barcodePrice){

        if (button.getText()=="예"){
            c.accept_barcode(button, cart, order, up,barcodePrice);
        }
        else if (button.getText()=="아니오"){
            c.accept_barcode(button, cart, order, up,barcodePrice);
        }
        else if (button.getText()=="카드 리더기"){
            c.accept_barcode(button, cart, order, up,barcodePrice);
            System.out.println("테스트용");
            up.displayPrompt("Barcode Enabled",up,c,cart,order,barcodePrice); //이걸로 인해 생긴 영수증 윗 버튼 누르면 영수증 제대로뜸 ㅁㅊ
        }
        else
            c.accept_barcode(button, cart, order, up,barcodePrice);
    }
    // operation
    public void getBtnPress(JButton button, CartMenu cart, Controller c,Order order, UserPanel up){
        if (button.getText()=="카드결제") {

            c.accept(button, cart, order, up);
            userPanelFrame.setVisible(false);
        }
        else if (button.getText()=="카드"){
           c.accept(true,up);
        }
        else if (button.getText()=="쿠폰"){
            c.accept(button, cart, order, up);
            userPanelFrame.setVisible(false);
        }
        else if (button.getText()=="예"){

            c.accept(button, cart, order, up);
        }
        else if (button.getText()=="아니오"){
            c.accept(button, cart, order, up);
        }
        else if (button.getText()=="카드 리더기"){
            if (cart.getNum()==0){// 카트에 물건 없음
                //
            }
            else
                c.accept(insertCardBtn, cart,order, up);
        }
        else if (button.getText()=="바코드 인식"){
            if (cart.getNum()==0){// 카트에 물건 없음
                //
            }
            else
                c.accept(showBarcodeBtn, cart,order, up);
        }
        else
            System.out.println("");
    }
    public void scan(JButton button, CartMenu cart, Controller c,Order order, UserPanel up){
        c.accept(button, cart, order, up);

    }
    public void displayPrompt(String text, UserPanel up){
        if (text=="Order Complete")
            up.orderCompletePage();
        else if (text=="overLimit" || text=="expired" )
            up.approvalErrorPage(text);




    }
    public void displayPrompt(String text, UserPanel up, Controller c, CartMenu cart, Order order){
        if (text=="영수증받말"  ){
            up.isReceiptPrintPage(c, cart, order,up);
        }


    }

    public void displayPrompt(String text, UserPanel up, Controller c, CartMenu cart, Order order, int barcodePrice){
        if (text=="남은 잔액 결제(카드) -카드리더기 클릭해주세요"){
             up.orderConfirmationPage(c, cart, order, barcodePrice);}
        else if (text=="Barcode Enabled"){
            up.orderConfirmationPage(c, cart, order, barcodePrice);
            up.isReceiptPrintPage_barcode(c, cart, order,up,barcodePrice);}
        else if (text=="영수증받말"  ){
            up.isReceiptPrintPage_barcode(c, cart, order,up,barcodePrice);
        }


    }



    public static void main(String[] args) { // 메인 함수
        FoodMenu cheeseBurger = new FoodMenu("Burger", "치즈버거", "./image/1.jpeg", 5000);
        FoodMenu doubleBurger = new FoodMenu("Burger", "더블버거", "./image/2.jpeg", 6000);
        FoodMenu chickenBurger = new FoodMenu("Burger", "치킨버거", "./image/3.jpeg", 5500);
        FoodMenu coke = new FoodMenu("drink", "코카콜라", "./image/4.jpeg", 2500);
        FoodMenu potato = new FoodMenu("side", "감자튀김", "./image/5.jpeg", 1900);
        FoodMenu cheeseStick = new FoodMenu("side", "치즈스틱", "./image/6.jpeg", 2200);
        FoodMenu cornSalad = new FoodMenu("side", "콘샐러드", "./image/7.png", 3100);
        FoodMenu onionRing = new FoodMenu("side", "어니언링", "./image/8.png", 2000);
        FoodMenu menu[] = {cheeseBurger, doubleBurger, chickenBurger, coke, potato, cheeseStick, cornSalad, onionRing};

        CartMenu cart=new CartMenu();
        Controller c = new Controller();
        Order order=new Order();
        UserPanel userPanel = new UserPanel();

        userPanel.mainPage(menu, menu.length, cart, c, order);

//
//        userPanel.orderCompletePage();
//        userPanel.insertCardPage();
//        userPanel.isReceiptPrintPage();


//        userPanel.orderCompletePage();
//        userPanel.insertCardPage();
//        userPanel.isReceiptPrintPRage();
//        userPanel.approvalErrorPage();
    }
}
