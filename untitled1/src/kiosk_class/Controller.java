package kiosk_class;

import gui.UserPanel;

import javax.swing.*;
public class Controller {

    CardReader cr = new CardReader();
    BarcodeReader br = new BarcodeReader();
    Payment pay = new Payment();
    public  void getCustomerInput(String menuName, int menuPrice, CartMenu cart, Order order, Controller c) {
        cart.addCartMenu(menuName, menuPrice, order, c);
        System.out.println(menuName+ menuPrice);
    }
    public void accept (JButton Btn, CartMenu cart, Order order, UserPanel up){
        String btnText = Btn.getText();
        if (btnText.equals("카드결제")) {
//            System.out.println("카드넣어");
//            displayPrompt("Input Card");

            //cartmenu {치즈버거,치즈버거,김치버거} -> 치즈2, 김치1 변경
            int p=0; //임시배열인덱스
             int TmenuQuantity[]={0,0,0,0,0,0,0,0,0,0};
             String TmenuName[]=new String[10];
            int TmenuPrice[]=new int[10];
             int isin=0;
            for (int i=0;i<cart.getNum();i++){
                for (int z=0; z<p;z++){
                    if (TmenuName[z] != null && TmenuName[z].equals(cart.getMenuName()[i])) {
                        TmenuQuantity[z]++; // 중복된 메뉴의 수량을 증가
                        isin = 1;
                        break;}
                }
                if(isin==0){
                    TmenuName[p]=cart.getMenuName()[i];
                    TmenuPrice[p]=cart.getPrice()[i];
                    TmenuQuantity[p]+=1;
                    p++;
//                    System.out.println("--메뉴추가--");
//                    System.out.println("p: "+p+ " 메뉴명: "+TmenuName[p-1]+ " 가격: "+TmenuPrice[p-1]);
                }
                isin=0;
            }
            cart.setMenuName(TmenuName);
            cart.setMenuQuantity(TmenuQuantity);
            cart.setPrice(TmenuPrice);
            cart.setNum(p);
            up.orderConfirmationPage(this,cart, order);
          //  OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame(cm);
        for (int i=0; i<cart.num;i++){
              System.out.println(cart.getMenuName()[i]);
              System.out.println("수량: "+cart.getMenuQuantity()[i]);}
        }
        else if(btnText.equals("예")) {
            int totalPrice = order.getTotalPrice();
            ReceiptPrinter rp = new ReceiptPrinter(); //수정요망
            rp.printReceipt(cart, order, this);
        }
        else if(btnText.equals("아니요")) {
            up.displayPrompt("주문완료");
        }
        else if(btnText.equals("기프티콘")) {
            up.displayPrompt("바코드 인식 부탁드립니다");
        }

    }
    public void receiveReceipt(CartMenu cm, Order totalPrice, String time) {
        for(int i = 0; i<cm.getNum(); i++) {
            System.out.println(cm.getMenuName()[i]);
            System.out.println(cm.getPrice()[i] * cm.getMenuQuantity()[i]);
        }
        System.out.println(totalPrice.getTotalPrice());
        System.out.println("현재 시간: " + time);
    }
    public void accept (boolean card, UserPanel up) {

        this.cr.inputCardInfo(card);
        up.displayPrompt("Insert Card");
    }

    public void ACKorNot(CartMenu cart, Order order){
      order.setTotalPrice(cart,this);
    }
    public void ACKorNot(CartMenu cm, int price){
        pay.getOrderInfo(cm,price);
     //   order.setTotalPrice(cm);
    }

    public void ACKorNot(CardReader cr) {
        long cardNumber = cr.getCardNumber();
        int cardExpirationDate = cr.getCardExpirationDate();
        pay.getCardInfo(cardNumber, cardExpirationDate);
    }
    public void ACKorNot(Payment pay, Order order, UserPanel up) {
        long cardNumber = cr.getCardNumber();
        int cardExpirationDate = cr.getCardExpirationDate();
        int totalPrice = order.getTotalPrice();
        int validNum = pay.checkForValid(cardNumber,cardExpirationDate ,totalPrice);

        if(validNum == 0 ) up.displayPrompt("한도초과 되었습니다");
        else if (validNum == 1) up.displayPrompt("만료된 카드 입니다.");
        else up.displayPrompt("영수증을 출력하시겠습니까?");
    }
    //public void accept(JButton Btn) {
//        switch () {
//            case "value1":
//                // value1과 일치하는 경우 실행될 코드
//                break;
//            case value2:
//                // value2와 일치하는 경우 실행될 코드
//                break;
//            // 추가적인 case문
//            default:
//                // 위의 어떤 case에도 해당하지 않는 경우 실행될 코드
//        }

    //}
    //order.setTotalPrice(cm);

    public void receiveReceipt(String[]receipt) {

    }

}
