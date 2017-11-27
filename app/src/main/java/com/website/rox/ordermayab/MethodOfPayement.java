package com.website.rox.ordermayab;

/**
 * Created by admin on 27/11/2017.
 */

public class MethodOfPayement {

    String cardNumber;
    String expirationDate;
    String cryptogram;
    String cardHolder;

    MethodOfPayement(String cardNumber, String expirationDate,
            String cryptogram, String cardHolder){
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cryptogram = cryptogram;
        this.cardHolder = cardHolder;
    }

}
