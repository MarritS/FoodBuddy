package com.marrits.foodbuddy;

import java.util.Date;

public class FoodItem {


    private String name;
    private int Id;

    FoodItem(String name, int id) {
        this.name = name;
        this.Id = id;
    }

    String getName() {
        return name;
    }

    int getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Id(int id) {
        this.Id = id;
    }

}
