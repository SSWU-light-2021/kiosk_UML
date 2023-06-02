package kiosk_class;

import gui.OrderConfirmationFrame;

import javax.swing.*;
public class Controller {
//    UserPanel up = new UserPanel();
    CartMenu cm = new CartMenu();
    Order order = new Order();

    CardReader cr = new CardReader();
    BarcodeReader br = new BarcodeReader();
    Payment pay = new Payment();
    public  void getCustomerInput(String menuName, int menuPrice) {
        this.cm.getMenu(menuName, menuPrice);
        System.out.println(menuName+ menuPrice);
    }
    public void accept (JButton Btn){
        String btnText = Btn.getText();
        if (btnText.equals("결제")) {
            System.out.println("카드넣어");
//            displayPrompt("Input Card");
            //cartmenu {치즈버거,치즈버거,김치버거} -> 치즈2, 김치1 변경

            int p=0; //임시배열인덱스
             int TmenuQuantity[]={0,0,0,0,0,0,0,0,0,0};
             String TmenuName[]=new String[10];
            int TmenuPrice[]=new int[10];
             int isin=0;
            for (int i=0;i<cm.getNum();i++){
                for (int z=0; z<TmenuName.length;z++){
                    if (TmenuName[z]==cm.getMenuName()[i]) {
                        TmenuQuantity[z]++;  isin=1; break;
                    }
                }
                if(isin==0){
                    TmenuName[p]=cm.getMenuName()[i];
                    TmenuPrice[p]=cm.getPrice()[i];
                    TmenuQuantity[p]+=1;
                    p++;
                }
                isin=0;
            }
            cm.setMenuName(TmenuName);
            cm.setMenuQuantity(TmenuQuantity);
            cm.setPrice(TmenuPrice);

            OrderConfirmationFrame orderConfirmationFrame = new OrderConfirmationFrame(cm);

        }

    }






    public void accept (boolean card) {
        this.cr.inputCardInfo(card);
        displayPrompt("Insert Card");
    }

    public void ACKorNot(CartMenu cm){
//        for (int i=0; i<cm.num;i++)
//              System.out.println("카트: "+ cm.getMenuName()[i]);
      new Order().setTotalPrice(cm);
    }
    public void ACKorNot(CartMenu cm, int price){
        pay.getOrderInfo(cm,price);
        order.setTotalPrice(cm);
    }

    public void ACKorNot(CardReader cr) {
        long cardNumber = cr.getCardNumber();
        int cardExpirationDate = cr.getCardExpirationDate();
        pay.getCardInfo(cardNumber, cardExpirationDate);
    }
    public void ACKorNot(Payment pay) {

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
public void displayPrompt(String msg) {
    System.out.println(msg);
}
    public void receiveReceipt(String[]receipt) {

    }

}
