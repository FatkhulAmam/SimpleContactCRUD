package com.gathco.contactcrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db_contact";

    public static final String tb_contact = "tb_contact";

    public static final String tb_contact_id = "tb_contact_id";
    public static final String tb_contact_name = "tb_contact_name";
    public static final String tb_contact_number = "tb_contact_number";

    private static final String CREATE_TABLE_CONTACT = "CREATE TABLE " + tb_contact + "("
            + tb_contact_id + " INTEGER PRIMARY KEY ,"
            + tb_contact_name + " TEXT,"
            + tb_contact_number + " TEXT"
            + ")";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

    }

    public void createContact(ModalContact mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_contact_id, mdNotif.get_id());
        values.put(tb_contact_name, mdNotif.get_name());
        values.put(tb_contact_number, mdNotif.get_number());
        db.insert(tb_contact, null, values);
        db.close();
    }

    public List<ModalContact> ReadContact() {
        List<ModalContact> titleListModel = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + tb_contact;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModalContact mdContact = new ModalContact();
                mdContact.set_id((cursor.getString(0)));
                mdContact.set_name((cursor.getString(1)));
                mdContact.set_number((cursor.getString(2)));
                titleListModel.add(mdContact);
            } while (cursor.moveToNext());
        }
        db.close();
        return titleListModel;
    }

    public int UpdateContact (ModalContact mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_contact_name, mdNotif.get_name());
        values.put(tb_contact_number, mdNotif.get_number());

        return db.update(tb_contact, values, tb_contact_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteContact (ModalContact mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_contact, tb_contact_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
