package com.website.rox.ordermayab;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RestaurantSignIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_sign_in);

        // Putting cursor on first editText
        EditText name_EditText = (EditText)findViewById(R.id.name_restaurant_editText);
        name_EditText.requestFocus();

        // morning_hours spinner
        Spinner morning_hours_spinner = (Spinner) findViewById(R.id. morning_hours_spinner);
        ArrayAdapter<CharSequence>  morning_hours_adapter = ArrayAdapter.createFromResource(this,
                R.array.hours, android.R.layout.simple_spinner_item);
        morning_hours_adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        morning_hours_spinner.setAdapter( morning_hours_adapter);

        // afternoon_hours spinner
        Spinner afternoon_hours_spinner = (Spinner) findViewById(R.id. afternoon_hours_spinner);
        ArrayAdapter<CharSequence>  afternoon_hours_adapter = ArrayAdapter.createFromResource(this,
                R.array.hours, android.R.layout.simple_spinner_item);
        afternoon_hours_adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        afternoon_hours_spinner.setAdapter(afternoon_hours_adapter);

    }

    public void addARestaurant(View view){

        EditText name_EditText = (EditText)findViewById(R.id.name_restaurant_editText);
        EditText manager_EditText = (EditText)findViewById(R.id.manager_restaurant_editText);
        EditText cuisine_EditText = (EditText)findViewById(R.id.cuisine_restaurant_editText);
        Spinner morning_hours_spinner = (Spinner)findViewById(R.id.morning_hours_spinner);
        Spinner closing_hours_spinner = (Spinner)findViewById(R.id.afternoon_hours_spinner);

        String name = name_EditText.getText().toString();
        String manager = manager_EditText.getText().toString();
        String cuisine = cuisine_EditText.getText().toString();
        String opening_hour = morning_hours_spinner.getSelectedItem().toString();
        String closing_hour = closing_hours_spinner.getSelectedItem().toString();

        // All fields must be complete
        if (name.isEmpty() || manager.isEmpty() || cuisine.isEmpty()){

            Snackbar error_empty_field_snackbar = Snackbar.make(
                    findViewById(R.id.name_restaurant_editText),
                    "All fields must be completed", Snackbar.LENGTH_LONG);
            error_empty_field_snackbar.show();

        }else{

            // ADD TO DATABASE
            if (true){
                // Successfully added to database
                // name, manager, cuisine, opening_hour, closing_hour
                Intent successfulRestaurantAdditionIntent = new Intent(
                        this,SuccessfulRestaurantAddition.class);
                startActivity(successfulRestaurantAdditionIntent);
            }else{
                // Database Error
                Intent additionErrorIntent = new Intent(
                        this,SuccessfulClientAddition.class);
                startActivity(additionErrorIntent);
            }

        }



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
