package com.gathco.contactcrud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends Activity {

    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseHandler db;
    private List<ModalContact> ListContact = new ArrayList<ModalContact>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        db = new DatabaseHandler(this);

        adapter_off = new CustomListAdapter(this, ListContact );
        mListView = (ListView) findViewById(R.id.listContact);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener((adapterView, view, i, l) -> ReadActivity.this.onEditContact());
        mListView.setClickable(true);
        ListContact.clear();

        List<ModalContact> contacts = db.ReadContact();
        for (ModalContact cn : contacts) {
            ModalContact judulModel = new ModalContact();
            judulModel.set_id(cn.get_id());
            judulModel.set_name(cn.get_name());
            judulModel.set_number(cn.get_number());
            ListContact.add(judulModel);

            if ((ListContact.isEmpty()))
                Toast.makeText(ReadActivity.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    public void onEditContact() {
        Intent intent = new Intent(this, UpdateDeleteActivity.class);
        startActivity(intent);
    }
}
