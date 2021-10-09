package com.gathco.contactcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createButton, readButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createButton = (Button) findViewById(R.id.createContact);
        readButton = (Button) findViewById(R.id.readContact);

        createButton.setOnClickListener(__->onCreateContact());
        readButton.setOnClickListener(__->onReadContact());
    }

    private void onCreateContact(){
        final Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    private void onReadContact(){
        final Intent intent = new Intent(this, ReadActivity.class);
        startActivity(intent);
    }
}