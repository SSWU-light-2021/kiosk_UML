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

    public int addCartMenu(String menuName, int price, Order order, Controller c) { //controller->CartMenu 메뉴받아오기
        this.menuName[num]=menuName;
        this.price[num]=price;
        // 수량 저장
        int p=0; //임시배열인덱스
        int TmenuQuantity[]={0,0,0,0,0,0,0,0,0,0};
        String TmenuName[]=new String[10];
        int TmenuPrice[]=new int[10];
        int isin=0;
        for (int i=0;i<num;i++){
            for (int z=0; z<p;z++){
                if (this.menuName[z] != null && TmenuName[z].equals(this.menuName[i])) { // 중복될 때
                    TmenuQuantity[z]++; // 중복된 메뉴의 수량을 증가
                    isin = 1;
                    break;}
            }
            if(isin==0){ // 중복 안 될 때
                TmenuName[p]=this.menuName[i];
             //   System.out.println("!!!!!!!!!"+this.menuName[i]);
                TmenuPrice[p]=this.price[i];
                TmenuQuantity[p] += 1;
                p++;
               // System.out.println("--메뉴추가--");
                //System.out.println("p: "+p+ " 메뉴명: "+TmenuName[p-1]+ " 가격: "+TmenuPrice[p-1]);
            }
            isin=0;
        }
//        System.out.println("cartmenu "+ this.menuName[num]);
        c.ACKorNot(this, order);
        return num++;
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
