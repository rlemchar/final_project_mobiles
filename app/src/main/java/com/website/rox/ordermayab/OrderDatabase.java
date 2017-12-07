package com.website.rox.ordermayab;

import android.companion.CompanionDeviceManager;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 04/12/2017.
 */

public class OrderDatabase {

    public static void addOrder(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orders = database.getReference("orders");

        //A SUPP
        MenuItem item = new MenuItem("spaghetti","muy bonito",50);
        Order ordertest = new Order(item,1,4,1);

        orders.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        orders.push().setValue(ordertest);

    }

    public static void getOrders(){
        Log.i("XMAS","Dans getOrders");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orders = database.getReference("orders");

        orders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("XMAS","Dans le single value");
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Order order = snapshot.getValue(Order.class);
                    if (order.restaurantID == LoggedIn.whoIsLoggedIn.ID){

                    }
                }



            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Code
            }
        });

    }

}
