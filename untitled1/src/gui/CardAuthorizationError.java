package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class CardAuthorizationError extends JFrame {
    CardAuthorizationError() {

        setTitle("햄버거 키오스크 _ 라이트!");
        JPanel approvalErrorTitleContainer=new JPanel();

        approvalErrorTitleContainer.setLayout(new BoxLayout(approvalErrorTitleContainer, BoxLayout.Y_AXIS)); // Set Y_AXIS layout
        approvalErrorTitleContainer.setBorder(new EmptyBorder(150, 0, 0, 0)); // Add top margin

        JLabel approvalErrorTitleLabel = new JLabel("<html><body style='text-align:center;'>승인오류<br /><br />초기 화면으로 돌아갑니다</body></html>");
        approvalErrorTitleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Set text alignment to center
        approvalErrorTitleContainer.add(approvalErrorTitleLabel);
        add(approvalErrorTitleContainer, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625,1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CardAuthorizationError();
    }
}
