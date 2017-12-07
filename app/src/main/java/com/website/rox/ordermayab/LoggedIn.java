package com.website.rox.ordermayab;

import java.util.List;

/**
 * Created by admin on 04/12/2017.
 */

public class LoggedIn {

    public static User whoIsLoggedIn = null;

    public static void setWhoIsLoggedIn(User user){
        whoIsLoggedIn = user;
    }

    public static void logOut(){
        whoIsLoggedIn = null;
    }

}
