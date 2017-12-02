package com.website.rox.ordermayab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RestaurantSignIn extends AppCompatActivity {

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
        EditText password_EditText = (EditText)findViewById(R.id.passwordRestaurant_editText);

        String name = name_EditText.getText().toString();
        String manager = manager_EditText.getText().toString();
        String cuisine = cuisine_EditText.getText().toString();
        String openingHour = morning_hours_spinner.getSelectedItem().toString();
        String closingHour = closing_hours_spinner.getSelectedItem().toString();
        String password = password_EditText.getText().toString();

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
                // name, manager, cuisine, openingHour, closing_hour, password

                // POUR RECUPERER LE ID D'UN USER AVANT DE L'AJOUTER À LA BDD
                // UTILISER getNextUserID()

                Intent successfulRestaurantAdditionIntent = new Intent(
                        this,SuccessfulRestaurantAddition.class);
                startActivityForResult(successfulRestaurantAdditionIntent,1);
            }else{
                // Database Error
                Intent additionErrorIntent = new Intent(
                        this,AdditionError.class);
                startActivityForResult(additionErrorIntent,1);
            }

        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("XMAS","Dans on activity result !!");
        Log.i("XMAS","RESUSLT CODE " + resultCode);

        if(resultCode==1){
            Log.i("XMAS","Result code == 1");
            setResult(1);
            finish();
        }
    }

    public int getNextUserID(){
        SharedPreferences settings = getSharedPreferences(MainActivity.SHARED_PREFERENCE_NAME, 0);
        int nextID = settings.getInt("ID_counter",0);

        if (nextID == 0){
            // Couldn't retrieve from sharedPreferences
            Log.i("XMAS","Error reading next user ID from database");
            return nextID;
        }else{
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("ID_counter",nextID+1);
            return  nextID;
        }

    }

}
