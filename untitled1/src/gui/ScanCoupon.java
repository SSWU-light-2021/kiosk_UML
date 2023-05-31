package gui;

import javax.swing.*;

public class ScanCoupon extends JFrame {
    public ScanCoupon() {
        JLabel scanCouponTitleLable = new JLabel("QR코드 스캔 하기");
        JButton cancelBtn = new JButton("취소");
        add("Center", scanCouponTitleLable);
        add("South",cancelBtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x클릭 시 run도 종료
        setSize(600, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ScanCoupon();
    }
}
