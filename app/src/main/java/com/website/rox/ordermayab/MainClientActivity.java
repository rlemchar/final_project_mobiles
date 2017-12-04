package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
    }

    public void Order (View v)
    {
        Intent goToSelectRestaurant = new Intent(this, ClientSelectRestaurantActivity.class);
        startActivity(goToSelectRestaurant);
    }

    public void seeOrder(View v)
    {
        Intent goToSeeOrder = new Intent(this, ClientSeeOrderActivity.class);
        startActivity(goToSeeOrder);
    }
}
