package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame{

    private receipt receiptScreen;
    main() {

        setTitle("햄버거 키오스크 _ 라이트!");

        JPanel mainContainer = new JPanel();
        mainContainer.setBorder(new EmptyBorder(120, 0, 0, 0)); // Add top margin
        mainContainer.setLayout(new GridBagLayout());

        // Create constraints for grid cells
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Allow components to fill the cell

        // Create the menu container panel
        JPanel menuContainer = new JPanel();
        menuContainer.setLayout(new GridLayout(3, 2));
        //메뉴1
        JPanel menu1 = new JPanel();
        menu1.setLayout(new GridLayout(5, 1));
        JPanel menuPic = new JPanel();
        JLabel menuPicLabel = new JLabel("사진");
        menuPic.add(menuPicLabel);
        JPanel menuName = new JPanel();
        JLabel menuNameLabel = new JLabel("싸이버거세트");
        menuName.add(menuNameLabel);
        JPanel menuDetail = new JPanel();
        JLabel menuDetailLabel = new JLabel("싸이버거+감튀+콜라");
        menuDetail.add(menuDetailLabel);
        JPanel menuPrice = new JPanel();
        JLabel menuPriceLabel = new JLabel("190000");
        menuPrice.add(menuPriceLabel);
        JPanel menuCart = new JPanel();
        JButton menuCartBtn = new JButton("Cart");
        menuCart.add(menuCartBtn);

        menu1.add(menuPic);
        menu1.add(menuName);
        menu1.add(menuDetail);
        menu1.add(menuPrice);
        menu1.add(menuCart);
        menuContainer.add(menu1);
        menu1.setBorder(new LineBorder(Color.BLACK, 1)); // Set the line border with black color and 1pt thickness

        for (int i = 0; i < 5; i++) {
            JPanel panel = new JPanel();
            panel.setBorder(new LineBorder(Color.BLACK, 1)); // Set the line border with black color and 1pt thickness
            menuContainer.add(panel);
        }
        //hw
        JPanel HWContainer = new JPanel();
        HWContainer.setLayout(new GridLayout(2, 2)); // Set GridLayout with 2 rows and 1 column

        JPanel receiptPanel = new JPanel();
        JPanel cardReaderPanel = new JPanel();
        JPanel barcodeReaderPanel = new JPanel();

        JLabel receiptLabel = new JLabel("영수증 나오는 곳"); // Set the text for the label
        receiptPanel.add(receiptLabel);
        JButton cardBtn=new JButton("카드 리더기");
        HWContainer.add(receiptPanel);
        HWContainer.add(cardBtn);

        JButton barcodeBtn = new JButton("바코드 인식");
        barcodeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 바코드 인식 버튼이 클릭되었을 때, cardApprovalScreen으로 화면 전환
                receiptScreen = new receipt();
                changeScreen(receiptScreen.getContentPane());
            }
        });

        HWContainer.add(new JPanel());
        HWContainer.add(barcodeBtn);

        HWContainer.add(barcodeBtn);
        mainContainer.add(menuContainer);
        mainContainer.add(HWContainer);

        add(mainContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(625, 1000);
        setVisible(true);
    }
    private void changeScreen(Container newScreen) {
        getContentPane().removeAll(); // 기존의 모든 컴포넌트 제거
        getContentPane().add(newScreen); // 새로운 화면 추가
        revalidate(); // 화면 갱신
        repaint();
    }

    public static void main(String[] args) {
        new main();
    }
}
