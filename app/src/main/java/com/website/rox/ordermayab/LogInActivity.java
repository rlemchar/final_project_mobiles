package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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

    public void LogIn (View v) {

        EditText id_edit = (EditText)findViewById(R.id.userId);
        EditText password_edit = (EditText)findViewById(R.id.password);

        if (validateEditText(id_edit) == false || validateEditText(password_edit) == false){
//            showSnackbar("Fill in the field!");
        } else {
            int id = Integer.parseInt(id_edit.getText().toString());
            String password = password_edit.getText().toString();

            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
            User user = databaseAccess.verifyLogin(id,password);

            if (user == null ){
                // wrong credential
                Snackbar Snackbar_wrongCredentials =
                        Snackbar.make(findViewById(R.id.login_title),"Wrong credentials",3);
                Snackbar_wrongCredentials.show();
                id_edit.setText("");
                password_edit.setText("");
            }else{
                if (user.type == User.userType.client){
                    LoggedIn.setWhoIsLoggedIn(user);
                    Intent clientIntent = new Intent(this, MainClientActivity.class);
                    startActivity(clientIntent);
                }else{
                    LoggedIn.setWhoIsLoggedIn(user);
                    Intent restaurantIntent = new Intent(this, MainRestauActivity.class);
                    startActivity(restaurantIntent);
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
