package com.website.rox.ordermayab;

/**
 * Created by broslaura on 27/11/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by leo_r on 02/11/2017.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLiteHelper";
    //Database
    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "DatabaseRestaurant";

    private static final String TABLE_NAME1 = "ITEM_TABLE";
    private static final String KEY_ID = "ID";
    private static final String FOREIGNKEY_ID = "RESTOID";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_PRICE = "price";

    private static final String TABLE_NAME2 = "RESTAURANT_TABLE";
    private static final String KEY_IDRESTO = "ID";
    private static final String KEY_NAMERESTO = "nameResto";
    private static final String KEY_MANAGER = "manager";
    private static final String KEY_CUISINETYPE = "cuisineType";
    private static final String KEY_TYPE = "type";



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLEITEM = "CREATE TABLE " + TABLE_NAME1 + " ("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ FOREIGNKEY_ID + " INTEGER FOREIGN KEY," + KEY_NAME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT," + KEY_PRICE + " FLOAT" + ")";

        sqLiteDatabase.execSQL(CREATE_TABLEITEM);

        String CREATE_TABLERESTO = "CREATE TABLE " + TABLE_NAME2 + " ("
                + KEY_IDRESTO + " INTEGER PRIMARY KEY," + KEY_NAMERESTO + " TEXT,"
                + KEY_MANAGER + " TEXT," + KEY_CUISINETYPE + " TEXT,"
                 + KEY_TYPE  + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_TABLERESTO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME1);
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME2);
        onCreate(sqLiteDatabase);
    }

    public boolean addItem(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME1);

        long result = db.insert(TABLE_NAME1, null, contentValues);

        if (result == -1) {
            return false;
        }else{
            return true;
        }
    }

    public boolean addRestaurant(String restaurant) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, restaurant);

        Log.d(TAG, "addData: Adding " + restaurant + " to " + TABLE_NAME1);

        long result = db.insert(TABLE_NAME1, null, contentValues);

        if (result == -1) {
            return false;
        }else{
            return true;
        }
    }

    //RETURNS ALL DATA FROM DATABSE
    public Cursor getItemData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME1;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    //RETURNS ONLY THE ID THAT MATCHES THE NAME PASSED IN
    public Cursor getItemID(String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + KEY_ID + " FROM " + TABLE_NAME1 +
                " WHERE " + KEY_NAME + " = '" + nombre + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateItem(String newNombre, int id, String oldNombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME1 + " SET " + KEY_NAME +
                " = '" + newNombre + "' WHERE " + KEY_ID + " = '" + id + "'" +
                " AND " + KEY_NAME + " = '" + oldNombre + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newNombre);
        db.execSQL(query);
    }

    public void deleteItem(int id, String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        //ORIGINAL WAY TO DO IT
        String query = "DELETE FROM " + TABLE_NAME1 + " WHERE "
                + KEY_ID + " = '" + id + "'" +
                " AND " + KEY_NAME + " = '" + nombre + "'";

        //ALTERNATE WAY TO DO IT
//        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
//                + KEY_ID + " = '" + id + "'" +
//                " AND " + KEY_NOMBRE + " = '" + nombre + "'" +
//                " AND " + KEY_APELLIDO + " = '" + apellido + "'" +
//                " AND " + KEY_ALTURA + " = '" + altura + "'" +
//                " AND " + KEY_PESO + " = '" + peso + "'";

        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + nombre + " from database.");
        db.execSQL(query);
    }
}