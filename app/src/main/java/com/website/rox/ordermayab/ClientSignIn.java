package com.website.rox.ordermayab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ClientSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sign_in);
    }

    public void addAClient(View view){
        Log.i("XMAS","Adding a client");
    }
}
