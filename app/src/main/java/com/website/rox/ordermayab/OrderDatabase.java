package com.website.rox.ordermayab;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by admin on 04/12/2017.
 */

public class OrderDatabase {

    public static void addOrder(Order order){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orders = database.getReference("orders");

        orders.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // ORDER ADDED !

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        orders.push().setValue(order);

    }

}
