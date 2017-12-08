package com.website.rox.ordermayab;

<<<<<<< HEAD
=======
import android.companion.CompanionDeviceManager;
import android.util.Log;

>>>>>>> 97fff2ec263dec6df80b207f772df2c85c5c68ef
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

    public static void addOrder(Order order){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orders = database.getReference("orders");

        orders.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        orders.push().setValue(order);

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
