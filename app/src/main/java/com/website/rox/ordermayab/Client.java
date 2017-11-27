package com.website.rox.ordermayab;

import static com.website.rox.ordermayab.User.userType.client;

/**
 * Created by admin on 23/11/2017.
 */

public class Client extends User {

    public enum careerType {
        medicine,
        architecture,
        design,
        engineering,
        psychology,
        business,
        communication,
        tourism
    }

    String universityID;
    String firstName;
    String lastName;
    int semester;
    careerType career;
    MethodOfPayement card=null;

    Client(String universityID, String firstName, String lastName,
           int semester, careerType career){
        super();
        type = client;
        this.universityID = universityID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.semester = semester;
        this.career = career;
    }

    void addMethodOfPayement( String cardNumber, String expirationDate,
            String cryptogram, String cardHolder){
        card = new MethodOfPayement(cardNumber,expirationDate,cryptogram,cardHolder);
    }


}
