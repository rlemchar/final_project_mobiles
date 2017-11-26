package com.website.rox.ordermayab;

/**
 * Created by admin on 23/11/2017.
 */

public abstract class User {

    public enum userType {
        client,
        restaurant
    }

    int ID;
    userType type;

}
