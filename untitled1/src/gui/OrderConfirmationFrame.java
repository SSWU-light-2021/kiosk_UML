package gui;
import javax.swing.*;
import java.awt.*;

public class OrderConfirmationFrame extends JFrame{
    public OrderConfirmationFrame(String[] menu, TextField[] suja, int[] price) {
        setTitle("Kiosk");

        // 주문 확인 페이지
        JLabel orderConfirmationTitleLabel = new JLabel("<주문 확인>"); // 주문 확인 title
        add("North",orderConfirmationTitleLabel);

        JPanel orderConfirmationContainer = new JPanel(new GridLayout(3,3,5,5)); // 주문 내역 확인 container
        orderConfirmationContainer.setPreferredSize(new Dimension(300,200));

//        JPanel orderConfirmationContainer = new JPanel(new GridLayout(0, 3)); // 주문 내역 확인 container
        JLabel orderProductTitleLabel = new JLabel("주문 제품"); // 주문 제품 title
        JLabel orderProductQuantityTitleLabel = new JLabel("수량"); // 수량 title
        JLabel orderProductAmountTitleLabel = new JLabel("금액"); // 금액 title
        orderConfirmationContainer.add(orderProductTitleLabel);
        orderConfirmationContainer.add(orderProductQuantityTitleLabel);
        orderConfirmationContainer.add(orderProductAmountTitleLabel);

// Loop through the selected menu items to populate the order information dynamically
        for (int i = 0; i < menu.length; i++) {
            int count = Integer.parseInt(suja[i].getText());
            if (count > 0) {
                JLabel orderProductLabel = new JLabel(menu[i]); // 주문 제품
                JLabel orderProductQuantityLabel = new JLabel(Integer.toString(count)); // 수량
                JLabel orderProductAmountLabel = new JLabel(Integer.toString(price[i] * count)); // 금액
                orderConfirmationContainer.add(orderProductLabel);
                orderConfirmationContainer.add(orderProductQuantityLabel);
                orderConfirmationContainer.add(orderProductAmountLabel);
            }
        }


//        orderConfirmationContainer.add(orderConfirmationRow2Container); // 주문 내역 확인 container에 포함

        JPanel orderAmountContainer = new JPanel(new GridLayout(3,2,5,5)); // 주문 내역 확인 container
        JLabel orderAmountTitleLabel = new JLabel("주문 금액"); // 주문 금액 title
        JLabel orderAmountLabel = new JLabel("16,500"); // 주문 금액
        JLabel discountAmountTitleLabel = new JLabel("할인 금액"); // 할인 금액 title
        JLabel discountAmountLabel = new JLabel("16,500"); // 할인 금액
        JLabel totalPaymentAmountTitleLabel = new JLabel("총 결제 금액"); // 총 결제 금액 title
        JLabel totalPaymentAmountLabel = new JLabel("0"); // 총 결제 금액
        orderAmountContainer.add(orderAmountTitleLabel);
        orderAmountContainer.add(orderAmountLabel);
        orderAmountContainer.add(discountAmountTitleLabel);
        orderAmountContainer.add(discountAmountLabel);
        orderAmountContainer.add(totalPaymentAmountTitleLabel);
        orderAmountContainer.add(totalPaymentAmountLabel);

        JPanel orderConfirmationBtnContainer = new JPanel(new GridLayout(0,2,5,5)); // 주문 내역 확인 container
        JButton cancelBtn = new JButton("취소");
        JButton paymentBtn = new JButton("결제");
        orderConfirmationBtnContainer.add(cancelBtn);
        orderConfirmationBtnContainer.add(paymentBtn);
        add("South", orderConfirmationBtnContainer);

//        add(orderConfirmationContainer); // Frame에 추가
//        add(orderAmountContainer);
        JPanel orderConfirmationCenterContainer = new JPanel(new GridLayout(2,0,5,5)); // 주문 내역 확인 container
        orderConfirmationCenterContainer.add(orderConfirmationContainer);
        orderConfirmationCenterContainer.add(orderAmountContainer);
        add("Center", orderConfirmationCenterContainer);
//        orderConfirmationContainer.setBackground(Color.PINK);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
        setSize(625, 1000);
        setVisible(true);
//        getContentPane().setBackground(Color.GREEN);
    }

    public static void main(String[] args) {
        Hamberger hamberger = new Hamberger();
        OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame(hamberger.menu, hamberger.suja, hamberger.price);

    }}
