package kiosk_class;

public class Payment {
    private String paymentType;
    private String date;
    private int paymentAmount;
    private boolean complete;
    private boolean isValidated;
    private boolean isProcessed;
    private boolean isCancelled;

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

    public String getPaymentType() {
        return paymentType;
    }

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

    public void printReceipt() {
        Order o = new Order();
        if (isProcessed) {
            // 영수증 출력 로직
            System.out.println("영수증을 출력합니다.");
            System.out.println("결제 금액: " + o.getOrderId());
        } else {
            System.out.println("결제가 아직 처리되지 않았습니다.");
        }
    }

    public void validatePayment(String validationCase) {
        switch (validationCase) {
            case "overLimit":
                displayPrompt("Over Limit");
                break;
            case "expired":
                displayPrompt("Expired");
                break;
            case "notReadCard":
                displayPrompt("Card Not Read");
                break;
            default:
                System.out.println("성공");
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
    public void getOrderInfo(CartMenu[] cartItems) {
        Order order = new Order();
        int totalPrice = order.getTotalPrice(cartItems);
        int totalQuantities = order.getTotalQuantities();
    }
    public int getUpdatedPaymentAmount(int totalPrice, int barcodePrice) {
        if(totalPrice <= barcodePrice ) return 0;
        else return totalPrice - barcodePrice;
    }
}
