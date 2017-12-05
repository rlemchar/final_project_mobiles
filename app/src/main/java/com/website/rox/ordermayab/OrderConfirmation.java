package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class OrderConfirmation extends AppCompatActivity {

    Intent m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
    m = getIntent();
        TextView title = (TextView) findViewById(R.id.title);
        String menu = m.getStringExtra("menuItem");
        Log.i("titel", menu);
        title.setText(menu);
    }

    public void Back(View v)
    {
        Intent goToStart = new Intent(this, MainClientActivity.class);
        startActivity(goToStart);
    }

}
