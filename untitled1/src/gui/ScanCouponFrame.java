package gui;

import javax.swing.*;
import java.awt.*;

public class ScanCouponFrame extends JFrame {
    public ScanCouponFrame() {
        JLabel scanCouponTitleLable = new JLabel("QR코드 스캔 하기");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton cancelBtn = new JButton("취소");
        add("Center", scanCouponTitleLable);
        bottomPanel.add("North",cancelBtn);

        // 하드웨어
        JPanel HWContainer = new JPanel();
        HWContainer.setLayout(new GridLayout(2, 2)); // Set GridLayout with 2 rows and 1 column

        JPanel receiptPanel = new JPanel();

        JLabel receiptLabel = new JLabel("영수증 나오는 곳"); // Set the text for the label
        receiptPanel.add(receiptLabel);
        JButton cardBtn=new JButton("카드 리더기");
        HWContainer.add(receiptPanel);
        HWContainer.add(cardBtn);

        JButton barcodeBtn = new JButton("바코드 인식");
        HWContainer.add(new JPanel());
        HWContainer.add(barcodeBtn);
        HWContainer.add(barcodeBtn);
        bottomPanel.add("South",HWContainer);
        add("South", bottomPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
        setSize(625, 1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ScanCouponFrame();
    }
}
