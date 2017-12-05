package com.website.rox.ordermayab;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ClientSelectRestaurantActivity extends AppCompatActivity {

    private static final String TAG = "ClientSelectRestaurantActivity";

    private SQLiteOpenHelper openHelper;
    private static SQLiteDatabase database;
    //private static DatabaseAccess db;
    private ListView mListView;

    Intent j;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_select_restaurant);


        mListView = (ListView) findViewById(R.id.listview);
        //openHelper = new SQLiteOpenHelper(this);

        populateListView();
        j = getIntent();
    }

    private void populateListView() {

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();


        final int clientId = LoggedIn.whoIsLoggedIn.ID;

    //GET THE DATA AND APPEND TO A LIST

        ArrayList<String> listData = databaseAccess.getNameRestaurants();

    //CREATE THE LIST ADAPTER AND SET THE ADAPTER
    ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(ClientSelectRestaurantActivity.this);
            databaseAccess.open();
            String restoName = adapterView.getItemAtPosition(i).toString();
            ArrayList<Restaurant> restaurants = databaseAccess.getRestaurants();
            //GET THE ID ASSOCIATED WITH THAT NAME
            //int index = restaurants.indexOf(restoName);
            //Log.i("index", "" + index);
            int restaurantId = restaurants.get(i).ID;
            String restoId = Integer.toString(restaurantId);
            Log.i("restaurantId", ""+  restaurantId);

           // int restaurantId = databaseAccess.getRestaurantIdByName(nombre);
            Intent chooseMenuScreenIntent = new Intent(ClientSelectRestaurantActivity.this, ClientChooseMenu.class);
            chooseMenuScreenIntent.putExtra("restaurantId",restoId);
            //chooseMenuScreenIntent.putExtra("nombre", nombre);
            //chooseMenuScreenIntent.putExtra("clientId", clientId);
            startActivity(chooseMenuScreenIntent);

        }

    });
}


}
