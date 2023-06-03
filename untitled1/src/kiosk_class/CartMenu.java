package kiosk_class;

public class CartMenu {
    private int menuQuantity[]=new int[10];
    private String menuName[]=new String[10];
    private int price[]=new int[10];
    private int totalPricePerMenu[] = new int[10];
    static int num=0;

    public int[] getMenuQuantity() {
        return menuQuantity;
    }

    public void setMenuQuantity (int[] menuQuantity) {
        for (int i = 0; i < 10; i++) {
            this.menuQuantity[i] = menuQuantity[i];
        }
    }
    public int getNum(){
    return num;
}

    public static void setNum(int num) {
        CartMenu.num = num;
    }

    public String[] getMenuName() {
        return menuName;
    }

    public void setMenuName(String[] menuName) {
        for (int i = 0; i < 10; i++) {
            this.menuName[i] = menuName[i];
        }
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        for (int i = 0; i < 10; i++) {
            this.price[i] = price[i];
        }
    }

    public void addCartMenu() {

    }

    public void removeCartMenu() {

    }

    public void addCartMenu(String menuName, int price, Order order, Controller c) { //controller->CartMenu 메뉴받아오기
        this.menuName[num]=menuName;
        this.price[num++]=price;
        c.ACKorNot(this, order);
    }

    public int[] getTotalPricePerMenu() {
        this.setTotalPricePerMenu();
        return totalPricePerMenu;
    }

    public void setTotalPricePerMenu() {
        for (int i = 0; i < 10; i++) {
            totalPricePerMenu[i] = price[i] * menuQuantity[i];
        }
    }
}
