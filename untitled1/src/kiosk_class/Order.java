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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(CartMenu[] cartItems) {
        for (CartMenu c:cartItems) {
            this.totalPrice += c.getTotalPricePerMenu();
        }
    }

    public int getTotalQuantities() {
        return totalQuantities;
    }

    public void setTotalQuantities(CartMenu[] cartItems) {
        for (CartMenu c:cartItems) {
            this.totalQuantities += c.getMenuQuantity();
        }
    }
}
