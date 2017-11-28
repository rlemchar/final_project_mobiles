package com.website.rox.ordermayab;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ClientSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sign_in);

        // Putting cursor on first editText
        EditText universityID_EditText = (EditText)findViewById(R.id.universityID_editText);
        universityID_EditText.requestFocus();

        // Semester spinner
        Spinner semester_spinner = (Spinner) findViewById(R.id.semester_spinner);
        ArrayAdapter<CharSequence> semester_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.semester, android.R.layout.simple_spinner_item);
        semester_spinner_adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        semester_spinner.setAdapter(semester_spinner_adapter);

        // Career spinner
        Spinner career_spinner = (Spinner) findViewById(R.id.career_spinner);
        ArrayAdapter<CharSequence> career_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.career, android.R.layout.simple_spinner_item);
        career_spinner_adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        career_spinner.setAdapter(career_spinner_adapter);
    }

    public void addAClient(View view){

        EditText universityID_EditText = (EditText)findViewById(R.id.universityID_editText);
        EditText firstName_EditText = (EditText)findViewById(R.id.firstName_editText);
        EditText lastName_EditText = (EditText)findViewById(R.id.lastName_editText);
        Spinner semester_spinner = (Spinner)findViewById(R.id.semester_spinner);
        Spinner career_spinner = (Spinner)findViewById(R.id.career_spinner);

        String universityID = universityID_EditText.getText().toString();
        String firstName = firstName_EditText.getText().toString();
        String lastName = lastName_EditText.getText().toString();
        String semester = semester_spinner.getSelectedItem().toString();
        String career = career_spinner.getSelectedItem().toString();

        // All fields must be complete
        if (universityID.isEmpty() || firstName.isEmpty() || lastName.isEmpty()){

            Snackbar error_empty_field_snackbar = Snackbar.make(
                    findViewById(R.id.universityID_editText),
                    "All fields must be completed", Snackbar.LENGTH_LONG);
            error_empty_field_snackbar.show();

        }else{

            // ADD TO DATABASE
            if (true){

                // Successfully added to database
                // universityID, firstName, lastName, semester, career

                Intent successfulClientAdditionIntent = new Intent(
                        this,SuccessfulClientAddition.class);
                startActivityForResult(successfulClientAdditionIntent,1);
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

}
