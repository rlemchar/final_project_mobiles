package com.website.rox.ordermayab;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FinaliseOrder extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalise_order);

        OrderDatabase.addOrder();
    }


}
