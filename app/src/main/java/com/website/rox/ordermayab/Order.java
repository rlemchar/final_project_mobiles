package com.website.rox.ordermayab;

/**
 * Created by admin on 04/12/2017.
 */

public class Order {

    public MenuItem item;
    public int quantity;
    public int restaurantID;
    public int clientID;

    Order(MenuItem item,
          int quantity,
          int restaurant,
          int client){

        this.item = item;
        this.quantity = quantity;
        this.restaurantID = restaurant;
        this.clientID = client;

    }

    Order(){

        this.item = null;
        this.quantity = 0;
        this.restaurantID = 0;
        this.clientID = 0;

    }
}
