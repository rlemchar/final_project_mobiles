package com.website.rox.ordermayab;

/**
 * Created by admin on 01/12/2017.
*/

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public static int verifyIdentifyers(int ID, String password) {
        Cursor cursor = database.rawQuery("SELECT password FROM users WHERE id=" + ID, null);
        String foundtype = "";
        int type = 0;
        if (cursor != null) {
            cursor.moveToFirst();
            String foundPassword = cursor.getString(0);
            if (foundPassword.equals(password)) {
                Cursor cursorType = database.rawQuery("SELECT type FROM users WHERE id=" + ID, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    foundtype = cursorType.getString(0);
                    if (foundtype.equals("client")) {
                        type = 1;

                    } else if (foundtype.equals("restaurant")) {
                        type = 2;
                    }
                }
            }
        }
        return type;
    }

}