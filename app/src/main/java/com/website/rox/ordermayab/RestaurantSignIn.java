package com.website.rox.ordermayab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RestaurantSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_sign_in);
    }

    public void addARestaurant(View view){
        EditText name_EditText = (EditText)findViewById(R.id.name_restaurant_editText);
        EditText manager_EditText = (EditText)findViewById(R.id.manager_restaurant_editText);
        EditText cuisine_EditText = (EditText)findViewById(R.id.cuisine_restaurant_editText);
    }
}
