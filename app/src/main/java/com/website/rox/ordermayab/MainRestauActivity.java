package com.website.rox.ordermayab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainRestauActivity extends AppCompatActivity {

    List<Order> allOrders = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_restau);

        //OrderDatabase.getOrders();
        //refreshOrdersDisplay();


    }
/*
    public void refreshOrdersDisplay(){

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                        );
        // Set The Adapter
        ListView orders_listView = (ListView)findViewById(R.id.orders_listView);
        orders_listView.setAdapter(arrayAdapter);

    }
*/


    public List<String> convertListOrderToListString(List<Order> orders){
        List<String> result = new ArrayList<String>();
        Iterator<Order> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            result.add(orderIterator.next().item.name);
        }

        return result;
    }

}
