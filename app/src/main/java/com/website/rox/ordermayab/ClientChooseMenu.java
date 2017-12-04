package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        populateListView();
        k = getIntent();
        String restaurantName = k.getStringExtra("restaurantId");
        TextView title = (TextView) findViewById(R.id.restaurant);
        title.setText(restaurantName);
    }

    private void populateListView() {

        int clientId = k.getIntExtra("clientId", 0);
        String restaurantName = k.getStringExtra("nombre");
        int restaurantId = k.getIntExtra("restaurantId",0);

        //GET THE DATA AND APPEND TO A LIST
        ArrayList<MenuItem> listData = instance.getMenuItems(restaurantId);


        //CREATE THE LIST ADAPTER AND SET THE ADAPTER
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String nombre = adapterView.getItemAtPosition(i).toString();
                int restaurantId = k.getIntExtra("restaurantId",0);
                int clientId = k.getIntExtra("clientId", 0);
                Intent chooseMenuScreenIntent = new Intent(ClientChooseMenu.this, PaymentActivity.class);
                chooseMenuScreenIntent.putExtra("id", restaurantId);
                chooseMenuScreenIntent.putExtra("menuItem", nombre);
                chooseMenuScreenIntent.putExtra("clientId", clientId);
                startActivity(chooseMenuScreenIntent);

            }

        });
    }
}