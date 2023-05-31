package gui;
        import javax.swing.*;
        import javax.swing.border.EmptyBorder;


public class orderComplete extends JFrame {
    orderComplete() {

        setTitle("햄버거 키오스크 _ 라이트!");
        JPanel orderCompleteContainer=new JPanel();
        orderCompleteContainer.setBorder(new EmptyBorder(150, 0, 0, 0)); // Add top margin

        JLabel orderCompleteTitleLabel=new JLabel("주문 완료");

        orderCompleteContainer.add(orderCompleteTitleLabel);
        add(orderCompleteContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625,1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new orderComplete();
    }
}
