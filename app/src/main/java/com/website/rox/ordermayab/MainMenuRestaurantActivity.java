package com.website.rox.ordermayab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainMenuRestaurantActivity extends AppCompatActivity {


    private static final String TAG = "MainMenuRestaurantActivity";

    SQLiteHelper mSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_restaurant);
    }




}
