package kiosk_class;

import java.util.HashMap;

public class SetMenu {
    private HashMap<String, String> component;

    public SetMenu(FoodMenu burger, FoodMenu drink, FoodMenu side) {
        this.component.put("burger", burger.getName());
        this.component.put("drink", drink.getName());
        this.component.put("side", side.getName());
    }

    public HashMap<String, String> getComponent() {
        return component;
    }

    public void setComponent(FoodMenu burger, FoodMenu drink, FoodMenu side) {
        this.component.replace("burger", burger.getName());
        this.component.replace("drink", drink.getName());
        this.component.replace("side", side.getName());
    }
}
