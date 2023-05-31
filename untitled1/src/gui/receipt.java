package gui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class receipt extends JFrame{
    receipt() {

        setTitle("햄버거 키오스크 _ 라이트!");
        JPanel printReceiptContainer=new JPanel();
        printReceiptContainer.setBorder(new EmptyBorder(150, 0, 0, 0)); // Add top margin


        JPanel btn=new JPanel();
        JLabel paymentCompleteTitleLabel=new JLabel("<html><body style='text-align:center;'>결제완료<br /><br />영수증을 출력하시겠습니까?</body></html>\"");
        printReceiptContainer.add(paymentCompleteTitleLabel);
        JButton receiptYesBtn=new JButton("Yes");
        btn.add(receiptYesBtn);
        JButton receiptNoBtn=new JButton("No");
        btn.add(receiptNoBtn);
        printReceiptContainer.add(paymentCompleteTitleLabel);
        printReceiptContainer.add(btn);
        add(printReceiptContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new receipt();
    }
}
