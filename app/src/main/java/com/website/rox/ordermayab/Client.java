package com.website.rox.ordermayab;

import static com.website.rox.ordermayab.User.userType.client;

/**
 * Created by admin on 23/11/2017.
 */

public class Client extends User {

    Client(){
        super();
        type = client;
    }
}
