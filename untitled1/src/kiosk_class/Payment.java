package kiosk_class;

import gui.UserPanel;

public class Payment {
    private String paymentType;
    private String date;
    private int paymentAmount;
    private boolean complete;
    private boolean isValidated;
    private boolean isProcessed;
    private boolean isCancelled;
    private int validNum;

    public Payment() {
    }

    public Payment(String paymentType, String date, int paymentAmount, boolean complete) {
        this.paymentType = paymentType;
        this.date = date;
        this.paymentAmount = paymentAmount;
        this.complete = complete;
        this.isValidated = false;
        this.isProcessed = false;
        this.isCancelled = false;

    }

    public Payment(int validNum) {
        this.validNum = validNum;
    }

    public String getPaymentType() {
        return paymentType;
    }

    Order o = new Order();

    public String getDate() {
        return date;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void processPayment() {
        if (isValidated) {
            // 실제 결제 처리 로직
            System.out.println("결제가 완료되었습니다.");
            isProcessed = true;
        } else {
            System.out.println("결제 처리할 수 없습니다. 유효하지 않은 결제이거나 취소된 결제입니다.");
        }
    }

    public boolean checkBarcode(long barcodeNumber){
        if (barcodeNumber>0){
            return true;
        }
        return false;
    }
    public int checkForValid(long barcodeNumber){
            boolean isValid=checkBarcode(barcodeNumber);
            if (isValid){
                System.out.println("Barcode: valid");
                return 2;
            }
            else
                return 1;
    }

    public int checkForValid(long cardNumber, int cardExpirationDate, int totalPrice, Controller c, UserPanel up, CartMenu cart, Order order) {
        boolean isOverLimit = checkLimit(cardNumber, totalPrice);
        boolean isExpired = checkExpiration(cardExpirationDate);
        isOverLimit=true;
        if (isOverLimit) {
            System.out.println("Payment declined: overLimit");
            c.ACKorNot(0, up, c, cart, order);
            return validNum = 0;
            // 추가적인 처리 (예: 거절 메시지 출력)
        } else if (isExpired) {
            System.out.println("Payment declined: expired");
            c.ACKorNot(1, up, c, cart, order);
            return validNum = 1;
            // 추가적인 처리 (예: 거절 메시지 출력)
        } else {
//            System.out.println("Payment accepted");
            c.ACKorNot(2, up, c, cart, order);
            return validNum = 2;
            // 추가적인 처리 (예: 승인 메시지 출력)
        }
    }

    public int checkForValid(long cardNumber, int cardExpirationDate, int totalPrice, Controller c, UserPanel up, CartMenu cart, Order order,int barcodePrice) {
        boolean isOverLimit = checkLimit(cardNumber, totalPrice);
        boolean isExpired = checkExpiration(cardExpirationDate);
        if (isOverLimit) {
            System.out.println("Payment declined: overLimit");
            c.ACKorNot_barcode(validNum, up, c, cart, order,barcodePrice);
            return validNum = 0;
            // 추가적인 처리 (예: 거절 메시지 출력)
        } else if (isExpired) {
            System.out.println("Payment declined: expired");
            c.ACKorNot_barcode(validNum, up, c, cart, order,barcodePrice);
            return validNum = 1;
            // 추가적인 처리 (예: 거절 메시지 출력)
        } else {
//           System.out.println("Payment accepted");
            c.ACKorNot_barcode(2, up, c, cart, order,barcodePrice);
            return validNum=2;
            // 추가적인 처리 (예: 승인 메시지 출력)
        }
    }
    public int checkForValid2(long cardNumber, int cardExpirationDate, int totalPrice, Controller c, UserPanel up, CartMenu cart, Order order,int barcodePrice) {
        boolean isOverLimit = checkLimit(cardNumber, totalPrice);
        boolean isExpired = checkExpiration(cardExpirationDate);

        if (isOverLimit) {
            System.out.println("Payment declined: overLimit");
            c.ACKorNot_barcode2(validNum, up, c, cart, order,barcodePrice);
            return validNum = 0;
            // 추가적인 처리 (예: 거절 메시지 출력)
        } else if (isExpired) {
            System.out.println("Payment declined: expired");
            c.ACKorNot_barcode2(validNum, up, c, cart, order,barcodePrice);
            return validNum = 1;
            // 추가적인 처리 (예: 거절 메시지 출력)
        } else {
//           System.out.println("Payment accepted");
            c.ACKorNot_barcode2(2, up, c, cart, order,barcodePrice);
            return validNum=2;
            // 추가적인 처리 (예: 승인 메시지 출력)
        }
    }
    public boolean checkLimit(long cardNumber, int totalPrice) {
        // 카드 한도 확인 로직
        // 예시로 임의로 한도 체크
        long cardLimit = 50000L;
        return totalPrice > cardLimit;
    }

    public boolean checkExpiration(int cardExpirationDate) {
        // 유효 기간 확인 로직
        // 예시로 임의로 현재 날짜와 비교하여 만료 여부 체크
        int currentYear = 2023; // 현재 연도
        int currentMonth = 6; // 현재 월
        int expirationYear = cardExpirationDate / 100;
        int expirationMonth = cardExpirationDate % 100;
        if (expirationYear < currentYear) {
            return false; // 유효 기간 만료
        } else if (expirationYear == currentYear && expirationMonth < currentMonth) {
            return false; // 유효 기간 만료
        } else {
            return true; // 유효 기간 유지
        }
    }

    public void displayPrompt(String message) {
        System.out.println(message);
    }

    public void cancelPayment() {
        // 결제 취소 로직
        isCancelled = true;
        System.out.println("결제가 취소되었습니다.");
    }

    public void getOrderInfo(CartMenu cartItems, int price) {
       // Order order = new Order();
        int totalPrice = price;
//        System.out.println("페이먼트: "+totalPrice);
    }

    public int getUpdatedPaymentAmount(int totalPrice, int barcodePrice) {
        if (totalPrice <= barcodePrice) return 0;
        else return totalPrice - barcodePrice;
    }

    CardReader cr = new CardReader();

    public String getCardInfo(long cardNumber, int cardExpirationDate, Order order, Controller c, UserPanel up, CartMenu cart) {
        checkForValid(cardNumber,cardExpirationDate,order.getTotalPrice(),c, up, cart, order);
        return "Card Number: " + cardNumber + ", Expiration Date: " + cardExpirationDate;
    }
    public String getCardInfo(long cardNumber, int cardExpirationDate, Order order, Controller c, UserPanel up, CartMenu cart,int barcodePrice) {
        checkForValid(cardNumber,cardExpirationDate,order.getTotalPrice(),c, up, cart, order,barcodePrice);
        return "Card Number: " + cardNumber + ", Expiration Date: " + cardExpirationDate;
    }
    public String getBarcodeInfo(long barcodeNum, int barcodeExpirationDate, int barcodePrice, Order order, Controller c,UserPanel up, CartMenu cart) {
        int n=checkForValid(barcodeNum);
        if (n==2){
            System.out.println(2);
            c.ACKorNot_barcode(2, up, c, cart, order, barcodePrice);}
        else
            c.ACKorNot(1, up, c, cart, order);
        return "Barcode Number: " + barcodeNum + " BarcodeExpiration Date: " + barcodeExpirationDate + "BarcodePrice" + barcodePrice;
    }
}