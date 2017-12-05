package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ClientChooseMenu extends AppCompatActivity {

    Intent k;
    private static DatabaseAccess instance;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_choose_menu);

        mListView = (ListView) findViewById(R.id.listview);
        //openHelper = new SQLiteOpenHelper(this);


        k = getIntent();
        String id = k.getStringExtra("restaurantId");
        Log.i("restoId dans ChooseMenu", "" + id);
        //String restaurantName = k.getStringExtra("restaurantId");
        //TextView title = (TextView) findViewById(R.id.restaurant);
        //title.setText(restaurantName);
        populateListView();
    }

    private void populateListView() {

        String resto = k.getStringExtra("restaurantId");
        int restaurantId = Integer.parseInt(resto);

        Log.i("restoId dans ChooseMenu", "" + restaurantId);
        //GET THE DATA AND APPEND TO A LIST
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        ArrayList<String> listData = databaseAccess.getMenuItemsNames(restaurantId);


        //CREATE THE LIST ADAPTER AND SET THE ADAPTER
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String menuName = adapterView.getItemAtPosition(i).toString();

                int restaurantId = k.getIntExtra("restaurantId",0);

                Intent chooseMenuScreenIntent = new Intent(ClientChooseMenu.this, PaymentActivity.class);
                //chooseMenuScreenIntent.putExtra("id", restaurantId);
                chooseMenuScreenIntent.putExtra("menuItem", menuName);
                startActivity(chooseMenuScreenIntent);

            }

        });
    }
}