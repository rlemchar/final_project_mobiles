package com.website.rox.ordermayab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PaymentActivity extends AppCompatActivity {

    Intent l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        l = getIntent();
    }

    public void Pay(View v){
        RadioButton efectivo = (RadioButton) findViewById(R.id.efectivopay);
        RadioButton card = (RadioButton) findViewById(R.id.cardbutton);

        if (efectivo.isChecked()){
            showSnackbar("payment of the order will be later!");
        }
        else if (card.isChecked()) {

            EditText name = (EditText) findViewById(R.id.name);
            EditText carnumber = (EditText) findViewById(R.id.cardnumber);
            EditText code = (EditText) findViewById(R.id.code);
            EditText month = (EditText) findViewById(R.id.month);
            EditText year = (EditText) findViewById(R.id.year);
            if (validateEditText(name) == false || validateEditText(carnumber) == false || validateEditText(code) == false
                    || validateEditText(month) == false || validateEditText(year) == false) {
                showSnackbar("please enter the fields!");
            } else {
                showSnackbar("Payment of the order effected!");
            }


        }
        Intent goToConfirm = new Intent(PaymentActivity.this, OrderConfirmation.class);
        String menuName = l.getStringExtra("menuItem");
        goToConfirm.putExtra("menuItem", menuName);
        startActivity(goToConfirm);
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

    private void showSnackbar(String msg) {
        Snackbar.make(findViewById(R.id.layoutpayment), msg, Snackbar.LENGTH_SHORT).show();
    }
}
