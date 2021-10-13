package com.gathco.contactcrud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UpdateDeleteActivity extends Activity {
    private DatabaseHandler db;
    private String sId, sName, sNumber;
    private EditText eName,eNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        db = new DatabaseHandler(this);

        Intent i = this.getIntent();
        sId = i.getStringExtra("iId");
        sName = i.getStringExtra("iName");
        sNumber = i.getStringExtra("iNumber");

        eName = findViewById(R.id.editName);
        eNumber = findViewById(R.id.editNumber);

        eName.setText(sName);
        eNumber.setText(sNumber);

        Button btnUpdate = (Button) findViewById(R.id.updateButton);
        btnUpdate.setOnClickListener(view -> {
            sName = String.valueOf(eName.getText());
            sNumber = String.valueOf(eNumber.getText());

            if (sName.equals("")){
                eName.requestFocus();
                Toast.makeText(UpdateDeleteActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            } else if (sNumber.equals("")){
                eNumber.requestFocus();
                Toast.makeText(UpdateDeleteActivity.this, "Please Enter Number", Toast.LENGTH_SHORT).show();
            } else {
                db.UpdateContact(new ModalContact(sId, sName, sNumber));
                Toast.makeText(UpdateDeleteActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button btnDelete = (Button) findViewById(R.id.deleteButton);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteContact(new ModalContact(sId, sName, sNumber));
                Toast.makeText(UpdateDeleteActivity.this, "DELETED", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
