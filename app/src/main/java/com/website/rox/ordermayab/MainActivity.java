package com.website.rox.ordermayab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signIn(View view){
        Intent goToSignIn = new Intent(this, SignIn.class);
        startActivity(goToSignIn);
    }

    public void logIn(View view){
        Intent goToLogIn = new Intent(this,LogIn.class);
        startActivity(goToLogIn);
    }
}
