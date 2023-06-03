package kiosk_class;

public class Order {
    private static int orderIdCounter = 0;
    private int orderId;
    private int totalPrice;
    private int totalQuantities;
    Controller controller;

    public Order() {
        orderId = ++orderIdCounter;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTotalPrice() {

        return totalPrice;
    }

    public void setTotalPrice(CartMenu cm, Controller c) {
        totalPrice=0;
        for (int i=0; i < 10; i++) {
        this.totalPrice += cm.getTotalPricePerMenu()[i];
        c.ACKorNot(cm,totalPrice);
    }}

    public int getTotalQuantities() {
        return totalQuantities;
    }

//    public void setTotalQuantities(CartMenu[] cartItems) {
//        for (CartMenu c:cartItems) {
//            this.totalQuantities += c.getMenuQuantity();
//        }
//    }
}
