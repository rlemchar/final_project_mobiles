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
    String opening_hour;
    String closing_hour;
    List<MenuItem> menu;

    Restaurant(int ID, String password,String name, String manager, String typeOfCuisine,
               String opening_hour, String closing_hour){
        super(ID,userType.restaurant,password);
        this.name = name;
        this.manager = manager;
        this.typeOfCuisine = typeOfCuisine;
        this.opening_hour = opening_hour;
        this.closing_hour = closing_hour;
        menu = new ArrayList<MenuItem>();
    }

    void addItemToMenu(MenuItem item){
        menu.add(item);
    }
}
