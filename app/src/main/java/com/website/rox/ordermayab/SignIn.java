package com.website.rox.ordermayab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignIn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.typeOfClient_RadioGroup);
        radioGroup.check(R.id.client_RadioButton);
    }

    public void next(View view){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.typeOfClient_RadioGroup);
        int radioButtonSelected = radioGroup.getCheckedRadioButtonId();

        Intent nextSignIn;

        if (radioButtonSelected == R.id.client_RadioButton){
            nextSignIn = new Intent(this,ClientSignIn.class);
        }else{
            nextSignIn = new Intent(this,RestaurantSignIn.class);
        }

        startActivityForResult(nextSignIn,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("XMAS","Dans on activity result");
        if (resultCode==1){
            finish();
        }
    }
}
