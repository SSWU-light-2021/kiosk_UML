package kiosk_class;

import gui.UserPanel;

import javax.swing.*;

public class Controller {
    UserPanel up = new UserPanel();
    CartMenu cm = new CartMenu();
    Order order = new Order();
    CardReader cr = new CardReader();
    BarcodeReader br = new BarcodeReader();
    Payment pay = new Payment();
    public  void getCustomerInput(String menuName, int menuPrice) {
        this.cm.getMenu(menuName, menuPrice);
    }
    public void accept (JButton Btn){
        String btnText = Btn.getText();
        if (btnText.equals("paymentBtn")) {
            displayPrompt("Input Card");
        }
    }
    public void accept (boolean card) {
        this.cr.inputCardInfo(card);
    }
    public String[] ACKorNot(String name, int num){
        String result[]={name, Integer.toString(num)};
        return result;
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
public void displayPrompt(String msg) {
    System.out.println(msg);
}
    public void receiveReceipt(String[] receipt) {

    }
}
