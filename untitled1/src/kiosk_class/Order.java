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

    public void setTotalPrice(CartMenu cm) {
        for (int i=0;i<cm.getMenuName().length;i++) {
            totalPrice+=cm.getMenuQuantity()[i]* cm.getPrice()[i];
        }
//        cm.setTotalPrice(totalPrice);
        controller.ACKorNot(cm,totalPrice);
    }

    public int getTotalQuantities() {
        return totalQuantities;
    }

//    public void setTotalQuantities(CartMenu[] cartItems) {
//        for (CartMenu c:cartItems) {
//            this.totalQuantities += c.getMenuQuantity();
//        }
//    }
}
