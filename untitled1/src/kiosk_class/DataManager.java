package kiosk_class;

public class DataManager {
    private boolean outOfStock;
    private String[] menuInfo = new String[4];

    public boolean getOutOfStock(FoodMenu menu) {
        return outOfStock;
    }
    public void setOutOfStock(FoodMenu menu) {
        this.outOfStock = outOfStock;
    }

    public String[] getMenuInfo(){
        return menuInfo;
    }
    public void setMenuInfo(String category, String name, String menuImage, int price) {
        menuInfo[0]=category;
        menuInfo[1]=name;
        menuInfo[2]=menuImage;
        menuInfo[3]=Integer.toString(price);
    }

    public void setPrice(FoodMenu menu, int price) {

    }

    public void addMenu(String[] menuInfo){

    }
    public void removeMenu(FoodMenu menu){

    }

}
