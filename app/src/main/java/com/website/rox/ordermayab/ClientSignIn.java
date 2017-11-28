package com.website.rox.ordermayab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ClientSignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_sign_in);

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
        Log.i("XMAS","Adding a client");
    }
}
