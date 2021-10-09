package com.gathco.contactcrud;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CreateActivity extends Activity {
    private DatabaseHandler db;
    private EditText eName, eNumber;
    private String sName, sNumber;
    private Button createButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = new DatabaseHandler(this);

        eName = (EditText) findViewById(R.id.contactName);
        eNumber = (EditText) findViewById(R.id.contactNumber);

        createButton = (Button) findViewById(R.id.createContact);
        createButton.setOnClickListener(view -> {
            sName = String.valueOf(eName.getText());
            sNumber = String.valueOf(eNumber.getText());

            if (sName.equals("")) {
                eName.requestFocus();
                Toast.makeText(this,"Please Insert Name", Toast.LENGTH_LONG).show();
            } else if (sNumber.equals("")) {
                eName.requestFocus();
                Toast.makeText(this,"Please Insert Number", Toast.LENGTH_LONG).show();
            } else {
                eName.setText("");
                eNumber.setText("");
                Toast.makeText(this,"Contact Added", Toast.LENGTH_LONG).show();
                db.createContact(new ModalContact(null, sName, sNumber));
            }
        });

    }
}
