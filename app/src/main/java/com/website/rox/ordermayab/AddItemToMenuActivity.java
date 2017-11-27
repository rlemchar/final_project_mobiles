package com.website.rox.ordermayab;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemToMenuActivity extends AppCompatActivity {

    private static final String TAG = "AddItemToMenuActivity";

    SQLiteHelper mSQLiteHelper;
    private Button addButton;
    private EditText Name, Description, Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_to_menu);

        Name = (EditText) findViewById(R.id.name);
        Description = (EditText) findViewById(R.id.Description);
        Price = (EditText) findViewById(R.id.price);
        mSQLiteHelper = new SQLiteHelper(this);
    }

    public void addButton(View view) {

        boolean boolName = validateEditText(Name);
        boolean boolDescription = validateEditText(Description);
        boolean boolPrice = validateEditText(Price);

        if (boolName == false || boolDescription == false || boolPrice == false) {
            showSnackbar("Faltan campos");
        }
        else {
            String name = Name.getText().toString();
            String description = Description.getText().toString();
            Double price = Double.parseDouble(Price.getText().toString());
            String dataStr = ("Name: " + name + "\n" + "description: " + description + "\n" +
                    "price: " + price + "\n" );
//        String dataStr = ("Nombre: " + nombreStr + "\n" + "Apellido: " + apellidoStr + "\n" +
//                "Altura: " + alturaStr + "\n" + "Peso: " + pesoStr);
            AddItems(dataStr);

        }

    }


    public void AddItems(String newEntry) {
        boolean insertData = mSQLiteHelper.addItem(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        }else{
            toastMessage("Something went wrong");
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

    private void showSnackbar(String msg) {
        Snackbar.make(findViewById(R.id.activity_add_item_to_menu), msg, Snackbar.LENGTH_SHORT).show();
    }

    //CUSTOMIZABLE TOAST MESSAGE
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
