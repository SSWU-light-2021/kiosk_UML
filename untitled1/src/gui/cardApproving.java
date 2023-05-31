package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class cardApproving extends JFrame {
    cardApproving() {

        setTitle("햄버거 키오스크 _ 라이트!");
        JPanel cardApprovalContainer=new JPanel();
        cardApprovalContainer.setBorder(new EmptyBorder(150, 0, 0, 0)); // Add top margin

        JLabel cardApprovalTitleLabel=new JLabel("카드 승인 중");

        cardApprovalContainer.add(cardApprovalTitleLabel);
        add(cardApprovalContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625,1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new cardApproving();
    }
}
