package gui;
import javax.swing.*;
import java.awt.*;

public class OrderConfirmationFrame extends JFrame{
    public OrderConfirmationFrame() {
        setTitle("Kiosk");

        // 주문 확인 페이지
        JLabel orderConfirmationTitleLabel = new JLabel("<주문 확인>"); // 주문 확인 title
        add("North",orderConfirmationTitleLabel);

        JPanel orderConfirmationContainer = new JPanel(new GridLayout(3,3,5,5)); // 주문 내역 확인 container
        orderConfirmationContainer.setPreferredSize(new Dimension(300,200));

//        JPanel orderConfirmationRow0Container = new JPanel(); // 주문 내역 0행 container
        JLabel orderProductTitleLabel = new JLabel("주문 제품"); // 주문 제품 title
        JLabel orderProductQuantityTitleLabel = new JLabel("수량"); // 수량 title
        JLabel orderProductAmountTitleLabel = new JLabel("금액"); // 금액 title
//        orderConfirmationRow0Container.add(orderProductTitleLabel);
//        orderConfirmationRow0Container.add(orderProductQuantityTitleLabel);
//        orderConfirmationRow0Container.add(orderProductAmountTitleLabel);
        orderConfirmationContainer.add(orderProductTitleLabel);
        orderConfirmationContainer.add(orderProductQuantityTitleLabel);
        orderConfirmationContainer.add(orderProductAmountTitleLabel);
//        orderConfirmationContainer.add(orderConfirmationRow0Container); // 주문 내역 확인 container에 포함

//        JPanel orderConfirmationRow1Container = new JPanel(); // 주문 내역 1행 container
        JLabel orderProductLabel1 = new JLabel("치즈버거"); // 주문 제품
        JLabel orderProductQuantityLabel1 = new JLabel("1"); // 수량
        JLabel orderProductAmountLabel1 = new JLabel("5500"); // 금액
//        orderConfirmationRow1Container.add(orderProductLabel1);
//        orderConfirmationRow1Container.add(orderProductQuantityLabel1);
//        orderConfirmationRow1Container.add(orderProductAmountLabel1);
        orderConfirmationContainer.add(orderProductLabel1);
        orderConfirmationContainer.add(orderProductQuantityLabel1);
        orderConfirmationContainer.add(orderProductAmountLabel1);
//        orderConfirmationContainer.add(orderConfirmationRow1Container); // 주문 내역 확인 container에 포함

//        JPanel orderConfirmationRow2Container = new JPanel(); // 주문 내역 2행 container
        JLabel orderProductLabel2 = new JLabel("불고기버거"); // 주문 제품
        JLabel orderProductQuantityLabel2 = new JLabel("2"); // 수량
        JLabel orderProductAmountLabel2 = new JLabel("11000"); // 금액
//        orderConfirmationRow2Container.add(orderProductLabel2);
//        orderConfirmationRow2Container.add(orderProductQuantityLabel2);
//        orderConfirmationRow2Container.add(orderProductAmountLabel2);
        orderConfirmationContainer.add(orderProductLabel2);
        orderConfirmationContainer.add(orderProductQuantityLabel2);
        orderConfirmationContainer.add(orderProductAmountLabel2);
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
        new OrderConfirmationFrame();
    }
}
