package kiosk_class;

public class CartMenu {
    private int menuQuantity[]=new int[10];
    private String menuName[]=new String[10];
    private int price[]=new int[10];
    private int totalPricePerMenu[] = new int[10];
    private int num=0;

    public int[] getMenuQuantity() {
        return menuQuantity;
    }

//    @Override
//    public String toString() {
//        return "CartMenu{" +
//                "menuQuantity=" + Arrays.toString(menuQuantity) +
//                ", menuName=" + Arrays.toString(menuName) +
//                ", price=" + Arrays.toString(price) +
//                ", totalPricePerMenu=" + Arrays.toString(totalPricePerMenu) +
//                '}';
//    }

    public void setMenuQuantity (int[] menuQuantity) {
        for (int i = 0; i < 10; i++) {
            this.menuQuantity[i] = menuQuantity[i];
        }
    }
    public int getNum(){
    return num;
}

    public void setNum(int num) {
        this.num = num;
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

    public void removeCartMenu() {

    }

    public int addCartMenu(String menuName, int price, int index, Order order, Controller c) { //controller->CartMenu 메뉴받아오기
        // 중복 체크
        if (this.menuName[index] != null && this.menuName[index].equals(menuName)) {
            menuQuantity[index]++;
            setTotalPricePerMenu(index);
            c.ACKorNot(this, order);
            return index;
        }

        // 중복되지 않은 메뉴일 경우
        this.menuName[index] = menuName;
        this.price[index] = price;
        menuQuantity[index] = 1;
        num+=1;
        setTotalPricePerMenu(index);

        c.ACKorNot(this, order);

        return index;
    }

    public int[] getTotalPricePerMenu() {
        return totalPricePerMenu;
    }

    public void setTotalPricePerMenu(int num) {
        totalPricePerMenu[num] = price[num] * menuQuantity[num];
    }
}















