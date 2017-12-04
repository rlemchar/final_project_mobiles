package com.website.rox.ordermayab;

import android.util.Log;

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

    Client(int ID,String password,String universityID, String firstName, String lastName,
           int semester, careerType career){
        super(ID,userType.client,password);
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

    public static careerType stringToCareerType(String career){
        if (career.equals("medecine")){
            return careerType.medicine;
        }else if (career.equals("architecture")){
            return careerType.architecture;
        }else if (career.equals("design")){
            return careerType.design;
        }else if (career.equals("engineering")){
            return careerType.engineering;
        }else if (career.equals("psychology")){
            return careerType.psychology;
        }else if (career.equals("business")){
            return careerType.business;
        }else if (career.equals("communication")){
            return careerType.communication;
        }else {
            return careerType.tourism;
        }
    }

    public void print(){
        Log.i("XMAS","CLIENT :" +this.ID + this.password + this.firstName+ this.career);
    }
}
