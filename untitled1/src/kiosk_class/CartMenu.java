package kiosk_class;

public class CartMenu {
    private int menuQuantity[]=new int[10];
    private String menuName[]=new String[10];
    private int price[]=new int[10];
    static int num=0;

//    public int[] getMenuQuantity() {
//        return menuQuantity;
//    }
//
//    public void setMenuQuantity[] (int menuQuantity) {
//        this.menuQuantity = menuQuantity;
//    }

    public String[] getMenuName() {
        return menuName;
    }
    public int[] getPrice() {
        return price;
    }

//    public void setMenuName(String menuName) {
//        this.menuName = menuName;
//    }
//
//    public int getTotalPricePerMenu() {
//        return totalPricePerMenu;
//    }
//
//    public void setTotalPricePerMenu(int totalPricePerMenu) {
//        this.totalPricePerMenu = totalPricePerMenu;
//    }

    public void addCartMenu() {

    }

    public void removeCartMenu() {

    }

    public void getMenu(String menuName, int price) { //controller->CartMenu 메뉴받아오기
        this.menuName[num]=menuName;
        this.price[num]=price;
        new Controller().ACKorNot(this);
    }
}
