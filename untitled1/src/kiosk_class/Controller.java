package kiosk_class;

import javax.swing.*;

public class Controller {
    CartMenu cm = new CartMenu();
    Order order = new Order();
    CardReader cr = new CardReader();
    BarcodeReader br = new BarcodeReader();
    Payment pay = new Payment();
    public  void getCustomerInput(String menuName, int menuPrice) {
        this.cm.getMenu(menuName, menuPrice);
    }
    public void ACKorNot(CartMenu cm){
      new Order().setTotalPrice(cm);
    }
    public void accept(JButton Btn) {
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

    }

        public void receiveReceipt(String[] receipt) {

        }

}
