package kiosk_class;

import javax.swing.*;

public class Controller {
    public  void getCustomerInput(JButton Btn) {
        if (Btn.getText()=="pickBtn"){

        }
    }
    public String[] ACKorNot(String name, int num){
        String result[]={name, Integer.toString(num)};
        return result;
    }
    public void accept(JButton Btn) {

    }
}
