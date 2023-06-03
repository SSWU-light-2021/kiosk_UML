package kiosk_class;
import gui.UserPanel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ReceiptPrinter {

    public void printReceipt(CartMenu cm, Order totalPrice, Controller c, UserPanel up, int barcodePrice) {
        // 현재 시간 가져오기
        LocalDateTime currentTime = LocalDateTime.now();

        // 시간 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 포맷에 맞게 시간 출력
        String formattedTime = currentTime.format(formatter);

        // 시간 출력
        //System.out.println("현재 시간: " + formattedTime);
        c.receiveReceipt(cm,totalPrice, formattedTime, up,barcodePrice);
    }

}
