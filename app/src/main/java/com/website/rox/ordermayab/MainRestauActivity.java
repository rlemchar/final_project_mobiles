package com.website.rox.ordermayab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainRestauActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_restau);
    }

    public void refreshOrdersDisplay(List<Order> orders){
        
    }
}
