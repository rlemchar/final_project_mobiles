package com.website.rox.ordermayab;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static public String SHARED_PREFERENCE_NAME = "sharedData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("XMAS","In on create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the first ID if it is the first time opening the app
        SharedPreferences settings = getSharedPreferences(SHARED_PREFERENCE_NAME, 0);
        if (!settings.contains("ID_counter")){
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("ID_counter",1111111);
            editor.commit();
        }
<<<<<<< HEAD
        //OrderDatabase.addOrder();
=======


>>>>>>> 97fff2ec263dec6df80b207f772df2c85c5c68ef
    }

    public void signIn(View view){
        Intent goToSignIn = new Intent(this, SignIn.class);
        startActivity(goToSignIn);
    }

    public void logIn(View view){
        Intent goToLogIn = new Intent(this,LogInActivity.class);
        startActivity(goToLogIn);
    }

}
