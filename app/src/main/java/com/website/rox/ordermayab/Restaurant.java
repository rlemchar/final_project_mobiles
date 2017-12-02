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
    String openingHour;
    String closingHour;
    List<MenuItem> menu;

    Restaurant(int ID, String password,String name, String manager, String typeOfCuisine,
               String openingHour, String closingHour){
        super(ID,userType.restaurant,password);
        this.name = name;
        this.manager = manager;
        this.typeOfCuisine = typeOfCuisine;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        menu = new ArrayList<MenuItem>();
    }

    void addItemToMenu(MenuItem item){
        menu.add(item);
    }
}
