package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void LogIn (View v)
    {
        EditText user = (EditText)findViewById(R.id.userId);
        EditText password = (EditText)findViewById(R.id.password);

        if (validateEditText(user) == false || validateEditText(password) == false  )
        {
//            showSnackbar("Fill in the field!");
        }
        else {
            int User = Integer.parseInt(user.getText().toString());
            String Password = password.getText().toString();
            int type = DatabaseAccess.verifyIdentifyers(User, Password);
            if(type !=0)
            {
                if(type==1){
                    com.website.rox.ordermayab.User.userType utype = com.website.rox.ordermayab.User.userType.client;
                    User connectedUser = null;
                    try {
                        connectedUser = com.website.rox.ordermayab.User.class.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    connectedUser.ID = User;
                    connectedUser.password= Password;
                    connectedUser.type = utype;
                    Intent i = new Intent(this, MainRestauActivity.class);
                    i.putExtra("user", User);
                    startActivity(i);
                }
                else{
                    com.website.rox.ordermayab.User.userType utype = com.website.rox.ordermayab.User.userType.restaurant;
                    User connectedUser = null;
                    try {
                        connectedUser = com.website.rox.ordermayab.User.class.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    connectedUser.ID = User;
                    connectedUser.password= Password;
                    connectedUser.type = utype;
                    Intent i = new Intent(this, MainClientActivity.class);
                    i.putExtra("user", User);
                    startActivity(i);



                }

            }

        }

    }

    private boolean validateEditText(EditText editText) {
        String data = editText.getText().toString();
        if (TextUtils.isEmpty(data) == true) {
            editText.setError("This field can not be empty!");
            Log.i("XMAS", "Empty Fiedl!");
            return false;
        }
        return true;
    }
}
