package gui;

import javax.swing.*;
import java.awt.*;

public class UserPanel {
    JFrame UserPanelFrame;

    JPanel panelContainer;
    JButton scrollBtn;

    // 카테고리 선택 bar
    JPanel categoryContainer;
    JButton setBtn;
    JButton burgerBtn;
    JButton sideBtn;
    JButton drinkBtn;

    // 메뉴
    JPanel foodMenuContainer;
    ImageIcon[] imageicon;
    Image[] image;
    JButton[] pic;
    JLabel menuTitleLabel;
    JLabel menuPriceLabel;
    JButton pickBtn;

    // 장바구니
    JPanel cartMenuContainer;
    JLabel itemTitleLabel;
    JLabel itemPriceLabel;
    JLabel itemQuantityLabel;
    JButton cartCancelBtn;
    JButton cartScrollBtn;

    // 주문
    JPanel orderContainer;
    JLabel orderTitleLabel; // 주문 내역
    JLabel quantityTitleLabel; // 수량(개)
    JLabel quantityLabel; // 숫자
    JLabel totalPriceTitleLabel; // 금액(원)
    JLabel totalPriceLabel; // 숫자
    JButton allOrderCancelBtn;

    // 결제
    JPanel paymentContainer;
    JButton paymentBtn;
    JButton couponBtn;

    // 주문 확인
    JPanel orderConfirmationContainer;
    JPanel orderListContainer;

    JLabel orderConfirmationTitleLabel;
    JLabel orderProductTitleLabel;
    JLabel orderProductQuantityTitleLabel;
    JLabel orderProductAmountTitleLabel;
    JLabel orderProductLabel;
    JLabel orderProductQuantityLabel;
    JLabel orderProductAmountLabel;

    JLabel orderAmountLabel;
    JLabel orderAmountTitleLabel;
    JLabel discountAmountLabel;
    JLabel discountAmountTitleLabel;
    JLabel totalPaymentAmountLabel;
    JLabel totalPaymentAmountTitleLabel;
    JButton cancelBtn;
    JButton finalpaymentBtn;

    JPanel orderCompleteContainer;
    JLabel orderCompleteTitleLabel;

    //쿠폰 스캔
    JPanel scanCouponContainer;
    JLabel scanCouponLabel;
    JButton orderCancelBtn;

    // 카드삽입
    JPanel insertCardContainer;
    JLabel insertCardTitleLabel;
    JLabel finalOrderAmountTitleLabel;
    JLabel finalOrderAmountLabel;

    //승인여부
    JPanel cardApprovalContainer;
    JLabel approvalErrorTitleLabel;

    //결제완료. 영수증출력여부 묻기기
    JPanel printReceiptContainer;
    JLabel paymentCompleteTitleLabel;
    JButton receiptYesBtn;
    JButton receiptNoBtn;

    // 물리적인 장치
    JPanel physicalPartsContainer;
    JButton insertCardBtn;
    JButton showBarcodeBtn;

}
