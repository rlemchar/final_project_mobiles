package com.website.rox.ordermayab;

/**
 * Created by admin on 01/12/2017.
*/

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private static SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    // Return a list of restaurants
    public ArrayList<String> getRestaurants(int dataToGet) {
        ArrayList<String>  list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM restaurants", null);
        cursor.moveToFirst();
        if(dataToGet==1){ //we want the name
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(1));
                cursor.moveToNext();
            }
            cursor.close();
        }
        else{ //we want the ID
            while (!cursor.isAfterLast()) {
                list.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        }

        return list;
    }

    public int  getRestaurantIdByName(String name) {
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT id FROM restaurants WHERE name=" + name, null);
        cursor.moveToFirst();
        int restaurantID = 0;
        while(cursor.moveToNext()) {
            restaurantID = cursor.getInt(0);
        }
      return restaurantID;
    }

    // Return a list of restaurants
    public  ArrayList<MenuItem> getMenuItems(int restaurant) {
        ArrayList<MenuItem> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM menuItem WHERE restaurantId=" + restaurant, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MenuItem item = new MenuItem(cursor.getString(0), cursor.getString(1), cursor.getDouble(2));
            list.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    // Verifies id and password
    public User verifyLogin(int ID, String password) {
        Cursor cursor = database.rawQuery("SELECT password FROM users WHERE id=" + ID, null);
        if (!cursor.isAfterLast()) {
            // The user exists
            cursor.moveToFirst();
            String foundPassword = cursor.getString(0);
            if (foundPassword.equals(password)) {
                // The password is correct
                return initiateUserFromDatabase(ID);
            }
        }
        return null;
    }

    private User initiateUserFromDatabase(int ID){
        Cursor cursorUser = database.rawQuery("SELECT * FROM users WHERE id=" + ID, null);
        User newUser;
        cursorUser.moveToFirst();
        if (cursorUser.getString(1).equals("Client")){
            // The logger is a Client
            Cursor cursorClient = database.rawQuery("SELECT * FROM clients WHERE id=" + ID, null);
            cursorClient.moveToFirst();
            newUser = new Client(ID,
                    cursorUser.getString(2),
                    cursorClient.getString(1),
                    cursorClient.getString(2),
                    cursorClient.getString(3),
                    Integer.parseInt(cursorClient.getString(4)),
                    Client.stringToCareerType(cursorClient.getString(4)));

        }else{
          // The logger is a Restaurant
            Cursor cursorRestaurant = database.rawQuery("SELECT * FROM restaurants WHERE id=" + ID, null);
            cursorRestaurant.moveToFirst();
            newUser = new Restaurant(ID,
                    cursorUser.getString(2),
                    cursorRestaurant.getString(1),
                    cursorRestaurant.getString(2),
                    cursorRestaurant.getString(3),
                    cursorRestaurant.getString(4),
                    cursorRestaurant.getString(5));
        }
        return newUser;
    }

}