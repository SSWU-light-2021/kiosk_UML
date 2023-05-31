package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class inputCard extends JFrame{
    inputCard() {

        setTitle("햄버거 키오스크 _ 라이트!");
        JPanel insertCardContainer = new JPanel();
        insertCardContainer.setBorder(new EmptyBorder(120, 0, 0, 0)); // Add top margin
        insertCardContainer.setLayout(new GridLayout(2, 1)); // Set GridLayout with 2 rows and 1 column

        JPanel insertCardTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Create a panel for insertCardTitleLabel with centered alignment
        JLabel insertCardTitleLabel = new JLabel("카드를 삽입해주세요");
        insertCardTitlePanel.add(insertCardTitleLabel);

        JLabel orderAmountTitleLabel = new JLabel("결제금액");
        JLabel orderAmountLabel = new JLabel(" 11000원");

        JPanel orderAmountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Create a panel for orderAmountTitleLabel and orderAmountLabel with centered alignment
        orderAmountPanel.add(orderAmountTitleLabel);
        orderAmountPanel.add(orderAmountLabel);

        insertCardContainer.add(insertCardTitlePanel);
        insertCardContainer.add(orderAmountPanel);

        add(insertCardContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625, 1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new inputCard();
    }
}
