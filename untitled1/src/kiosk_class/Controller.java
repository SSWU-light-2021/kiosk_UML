package kiosk_class;

import gui.UserPanel;

import javax.swing.*;
public class Controller {

    CardReader cr = new CardReader();
    BarcodeReader br = new BarcodeReader();
    Payment pay = new Payment();

    public int getCustomerInput(String menuName, int menuPrice, CartMenu cart, Order order, Controller c) {
        int cartNum = cart.addCartMenu(menuName, menuPrice, order, c);
//        System.out.println(menuName+ menuPrice);
        return cartNum;
    }
    public void accept (JButton Btn, CartMenu cart, Order order, UserPanel up){
        String btnText = Btn.getText();
        if (btnText.equals("카드결제")) {
//            System.out.println("카드넣어");
//            displayPrompt("Input Card");
            up.userPanelFrame.setVisible(false);
            JOptionPane.showMessageDialog(null, "카드리더기 버튼을 클릭해 카드를 넣어주세요", "알림", JOptionPane.INFORMATION_MESSAGE);

            //cartmenu {치즈버거,치즈버거,김치버거} -> 치즈2, 김치1 변경
            int p=0; //임시배열인덱스
             int TmenuQuantity[]={0,0,0,0,0,0,0,0,0,0};
             String TmenuName[]=new String[10];
            int TmenuPrice[]=new int[10];
             int isin=0;
            for (int i=0;i<cart.getNum();i++){
                for (int z=0; z<p;z++){
                    if (TmenuName[z] != null && TmenuName[z].equals(cart.getMenuName()[i])) { // 중복될 때
                        TmenuQuantity[z]++; // 중복된 메뉴의 수량을 증가
                        isin = 1;
                        break;}
                }
                if(isin==0){ // 중복 안 될 때
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
        }
        else if(btnText.equals("예")) {
            ReceiptPrinter rp = new ReceiptPrinter(); //수정요망
            up.isReceiptPrintFrame.setVisible(false);
            rp.printReceipt(cart, order, this, up);
        }
        else if(btnText.equals("아니오")) {
            up.isReceiptPrintFrame.setVisible(false);
            up.displayPrompt("Order Complete", up);
        }
        else if(btnText.equals("기프티콘")) {
            up.displayPrompt("바코드 인식 부탁드립니다", up);
        }
//        else if (btnText.equals("결제")){
//            cr.inputCardInfo(true, this);
//        }
        else if (btnText.equals("카드 리더기")){
            up.orderConfirmationFrame.setVisible(false);
            cr.inputCardInfo(true,this,pay, order, up, cart);
        }
        else if(btnText.equals("바코드")) {
            br.inputBarcodeInfo(true,this,pay, order);
        }
    }
    public void receiveReceipt(CartMenu cm, Order totalPrice, String time, UserPanel up) {
        System.out.println("================== 영수증 ==================");

        for (int i = 0; i < cm.getNum(); i++) {
            System.out.println(cm.getMenuName()[i] + "\t\t" + cm.getPrice()[i] + "원" + "\t\t수량: " + cm.getMenuQuantity()[i] + "개");
            System.out.println("\t\t\t\t\t\t합계: " + cm.getPrice()[i] * cm.getMenuQuantity()[i] + "원");
        }

        System.out.println("----------------------------------------------");
        System.out.println("총 가격:\t\t\t\t" + totalPrice.getTotalPrice() + "원");
        System.out.println("현재 시간:\t\t\t\t" + time);

        System.out.println("================== 영수증 끝 ==================");

        up.displayPrompt("Order Complete", up);
    }
    public void accept (boolean card, UserPanel up) {

//        this.cr.inputCardInfo(card);
        up.displayPrompt("Insert Card", up);
    }

    public void ACKorNot(CartMenu cart, Order order){
      order.setTotalPrice(cart,this);
    }
    public void ACKorNot(long cardN,int Ex, Payment pay, Order order, Controller c, UserPanel up, CartMenu cart){
        pay.getCardInfo(cardN,Ex, order,c, up, cart);
    }
    public void ACKorNot(int barcodeNum, int barcodeExpirationDate, int barcodePrice, Order order, Controller c) {
        pay.getBarcodeInfo(barcodeNum, barcodeExpirationDate, barcodePrice, order, c);
    }
    public void ACKorNot(CartMenu cm, int price){
        pay.getOrderInfo(cm,price);
     //   order.setTotalPrice(cm);
    }

    public void ACKorNot(Payment pay, Order order, UserPanel up, Controller c, CartMenu cart) {
        long cardNumber = cr.getCardNumber();
        int cardExpirationDate = cr.getCardExpirationDate();
        int totalPrice = order.getTotalPrice();
        int validNum = pay.checkForValid(cardNumber,cardExpirationDate ,totalPrice, c, up, cart, order);

        if(validNum == 0 ) up.displayPrompt("한도초과 되었습니다", up);
        else if (validNum == 1) up.displayPrompt("만료된 카드 입니다.", up);
        else up.displayPrompt("영수증을 출력하시겠습니까?", up);
    }
    public void ACKorNot(int validNum, UserPanel up, Controller c, CartMenu cart, Order order){ //ack6
        if (validNum==2){
            up.displayPrompt("영수증받말", up, c,  cart, order);

        }
        else if (validNum==0){
            up.displayPrompt("overLimit", up);
        }
        else if (validNum==1){
            up.displayPrompt("expired", up);
        }
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
