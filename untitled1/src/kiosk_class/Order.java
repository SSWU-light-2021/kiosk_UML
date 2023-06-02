package kiosk_class;

public class Order {
    private static int orderIdCounter = 0;
    private int orderId;
    private int totalPrice;
    private int totalQuantities;

    public Order() {
        orderId = ++orderIdCounter;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTotalPrice(CartMenu[] cartItems) {
        return totalPrice;
    }

    public void setTotalPrice(CartMenu cm) {
        for (int i=0;i<cm.getMenuName().length;i++) {
            totalPrice+=cm.getPrice()[i];
        }
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
