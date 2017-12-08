package com.website.rox.ordermayab;

/**
 * Created by admin on 27/11/2017.
 */

public class MenuItem {

    public String name;
    public String description;
    public double price;

    MenuItem(String name,String description,double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    MenuItem(){
        this.name = "";
        this.description = "";
        this.price = 0;
    }





}
