package com.website.rox.ordermayab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RestaurantSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_sign_in);
/*
        // morning_from spinner
        Spinner morning_from_spinner = (Spinner) findViewById(R.id.morning_from_spinner);
        ArrayAdapter<CharSequence> career_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.career, android.R.layout.simple_spinner_item);
        career_spinner_adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        career_spinner.setAdapter(career_spinner_adapter);
    */}

    public void addARestaurant(View view){
        EditText name_EditText = (EditText)findViewById(R.id.name_restaurant_editText);
        EditText manager_EditText = (EditText)findViewById(R.id.manager_restaurant_editText);
        EditText cuisine_EditText = (EditText)findViewById(R.id.cuisine_restaurant_editText);
    }
}
