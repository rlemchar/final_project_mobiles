package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.view.View;
=======
import android.util.Log;
>>>>>>> 045626f268c3fce8ea4c31a13f04d30d332875f2

public class MainClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_client);
    Log.i("XMAS","USER CONNECTED : " + LoggedIn.whoIsLoggedIn.ID);


    }

<<<<<<< HEAD
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
=======
>>>>>>> 045626f268c3fce8ea4c31a13f04d30d332875f2
}
