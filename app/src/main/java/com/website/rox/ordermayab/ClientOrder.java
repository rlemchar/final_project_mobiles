package com.website.rox.ordermayab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ClientOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_order);

        // Displaying the restaurants
        /*ListView restaurants_listView = (ListView)findViewById(R.id.restaurants_listView);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> restaurants = databaseAccess.getRestaurants();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, restaurants);
        restaurants_listView.setAdapter(adapter);
        */

    }
}
