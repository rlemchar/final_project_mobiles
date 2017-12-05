package com.website.rox.ordermayab;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
                // ORDER ADDED !

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        orders.push().setValue(ordertest);

    }

}
