package com.website.rox.ordermayab;





import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.website.rox.ordermayab.User.userType.restaurant;

/**
 * Created by admin on 23/11/2017.
 */

public class Restaurant extends User {

    String name;
    String manager;
    String typeOfCuisine;
    SimpleDateFormat[] schedule;
    List<MenuItem> menu;

    Restaurant(String name, String manager, String typeOfCuisine){
        super();
        type = restaurant;
        this.name = name;
        this.manager = manager;
        this.typeOfCuisine = typeOfCuisine;
        // A VOIR POUR SCHEDULE
        menu = new ArrayList<MenuItem>();
    }

    void addItemToMenu(MenuItem item){
        menu.add(item);
    }
}
