//package gui;
//
//import kiosk_class.CartMenu;
//import kiosk_class.Controller;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class OrderConfirmationFrame extends JFrame{
//
//    public OrderConfirmationFrame(Controller c, CartMenu cart) {
//        setTitle("Kiosk");
//
//        // 주문 확인 페이지
//        JLabel orderConfirmationTitleLabel = new JLabel("<주문 확인>"); // 주문 확인 title
//        add("North",orderConfirmationTitleLabel);
//
//        JPanel orderConfirmationContainer = new JPanel(new GridLayout(3,3,5,5)); // 주문 내역 확인 container
//        orderConfirmationContainer.setPreferredSize(new Dimension(300,200));
//
//        JPanel orderConfirmationRow2Container = new JPanel(new GridLayout(0, 3)); // 주문 내역 확인 container
//        JLabel orderProductTitleLabel = new JLabel("주문 제품"); // 주문 제품 title
//        JLabel orderProductQuantityTitleLabel = new JLabel("수량"); // 수량 title
//        JLabel orderProductAmountTitleLabel = new JLabel("금액"); // 금액 title
//        orderConfirmationContainer.add(orderProductTitleLabel);
//        orderConfirmationContainer.add(orderProductQuantityTitleLabel);
//        orderConfirmationContainer.add(orderProductAmountTitleLabel);
//        int totalPrice=0;
//// Loop through the selected menu items to populate the order information dynamically
//        for (int i = 0; i < cart.getNum(); i++) {
//                JLabel orderProductLabel = new JLabel(cart.getMenuName()[i]); // 주문 제품
//                JLabel orderProductQuantityLabel = new JLabel(Integer.toString(cart.getMenuQuantity()[i])); // 수량
//                JLabel orderProductAmountLabel = new JLabel(Integer.toString(cart.getPrice()[i] * cart.getMenuQuantity()[i]));
//                totalPrice+=cart.getPrice()[i] * cart.getMenuQuantity()[i];// 금액
//                orderConfirmationContainer.add(orderProductLabel);
//                orderConfirmationContainer.add(orderProductQuantityLabel);
//                orderConfirmationContainer.add(orderProductAmountLabel);
//        }
//
//
//
//        orderConfirmationContainer.add(orderConfirmationRow2Container); // 주문 내역 확인 container에 포함
//
//    JPanel orderAmountContainer = new JPanel(new GridLayout(3,2,5,5)); // 주문 내역 확인 container
//    JLabel orderAmountTitleLabel = new JLabel("주문 금액"); // 주문 금액 title
//    JLabel orderAmountLabel = new JLabel(Integer.toString(cart.getTotalPrice())); // 주문 금액
//    JLabel discountAmountTitleLabel = new JLabel("할인 금액"); // 할인 금액 title
//    JLabel discountAmountLabel = new JLabel(Integer.toString(0)); // 할인 금액
//    JLabel totalPaymentAmountTitleLabel = new JLabel("총 결제 금액"); // 총 결제 금액 title
//    JLabel totalPaymentAmountLabel = new JLabel(Integer.toString(cart.getTotalPrice()-0)); // 총 결제 금액
//        orderAmountContainer.add(orderAmountTitleLabel);
//        orderAmountContainer.add(orderAmountLabel);
//        orderAmountContainer.add(discountAmountTitleLabel);
//        orderAmountContainer.add(discountAmountLabel);
//        orderAmountContainer.add(totalPaymentAmountTitleLabel);
//        orderAmountContainer.add(totalPaymentAmountLabel);
//
//        JPanel orderConfirmationBtnContainer = new JPanel(new GridLayout(0,2,5,5)); // 주문 내역 확인 container
//        JButton cancelBtn = new JButton("취소");
//        JButton paymentBtn = new JButton("결제");
//        orderConfirmationBtnContainer.add(cancelBtn);
//        orderConfirmationBtnContainer.add(paymentBtn);
//        add("South", orderConfirmationBtnContainer);
//
////        add(orderConfirmationContainer); // Frame에 추가
////        add(orderAmountContainer);
//        JPanel orderConfirmationCenterContainer = new JPanel(new GridLayout(2,0,5,5)); // 주문 내역 확인 container
//        orderConfirmationCenterContainer.add(orderConfirmationContainer);
//        orderConfirmationCenterContainer.add(orderAmountContainer);
//        add("Center", orderConfirmationCenterContainer);
////        orderConfirmationContainer.setBackground(Color.PINK);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
//        setSize(625, 1000);
//        setVisible(true);
////        getContentPane().setBackground(Color.GREEN);
//
//        paymentBtn.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                c.accept(paymentBtn, cart,order, up);
////                OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame();
////                userPanelFrame.setVisible(false); // 창 안보이게 하기
//            }
//        });
//
//
//    }
//
//    public static void main(String[] args) {
//        Hamberger hamberger = new Hamberger();
////        OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame(hamberger.menu, hamberger.suja, hamberger.price);
//
//    }}