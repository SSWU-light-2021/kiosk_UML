package kiosk_class;

public class CartMenu {
    private int totalPrice = 0;
    private int menuQuantity[]=new int[10];
    private String menuName[]=new String[10];
    private int price[]=new int[10];
    static int num=0;
int totalPricePerMenu=0;
    public int[] getMenuQuantity() {
        return menuQuantity;
    }
//
//    public void setMenuQuantity[] (int menuQuantity) {
//        this.menuQuantity = menuQuantity;
//    }
public int getNum(){
    return num;
}

    public static void setNum(int num) {
        CartMenu.num = num;
    }

    public String[] getMenuName() {
        return menuName;
    }
    public int[] getPrice() {
        return price;
    }

    public void setMenuName(String[] menuName) {
        this.menuName = menuName;
    }
    public void setPrice(int[] price) {
        this.price = price;
    }
    public void setMenuQuantity(int[] num) {
        this.menuQuantity = num;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int num){
        this.totalPrice=num;
    }

    public void addCartMenu() {

    }

    public void removeCartMenu() {

    }

    public void getMenu(String menuName, int price, Order order, Controller c) { //controller->CartMenu 메뉴받아오기
        this.menuName[num]=menuName;
        this.price[num++]=price;
       System.out.println("cartmenu "+ this.menuName[num-1]);
        c.ACKorNot(this, order);
    }
}
