package com.example.tutorialtests.Data;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.tutorialtests.Model.Contact;
import com.example.tutorialtests.Util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
	public DatabaseHandler(Context context) {
		super(context,Util.DATABASE_NAME,null,Util.DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" + Util.KEY_ID + " INTEGER PRIMARY KEY," +
				Util.KEY_NAME + " TEXT," + Util.KEY_PHONE_NUMBER + " TEXT " + ")";

		db.execSQL(CREATE_CONTACT_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
		String DROP_TABLE = String.valueOf("DROP TABLE IF EXISTS");
		db.execSQL(DROP_TABLE,new String[]{Util.DATABASE_NAME});
		onCreate(db);

	}

	// takes in a contact of Contact class
	public void addContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues contentValues = new ContentValues();
		contentValues.put(Util.KEY_NAME,contact.getName());
		contentValues.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNumber());
		db.insert(Util.TABLE_NAME,null,contentValues);
		Log.i("Added","addContact: Item Added");
		db.close();
	}

	public void deleteContact(Contact id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(Util.TABLE_NAME,Util.KEY_ID + "=?",new String[]{
				String.valueOf(id.getId())});

		Log.i("Added","addContact: Item Added");
		db.close();
	}
	public void upDateContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues contentValues = new ContentValues();
		contact.setName(contact.getName());
		contact.setPhoneNumber(contact.getPhoneNumber());
		contentValues.put(Util.KEY_NAME,contact.getName());
		contentValues.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNumber());
		db.update(Util.TABLE_NAME, contentValues, Util.KEY_ID + "=?",new String[]{
				String.valueOf(contact.getId())} );
		Log.i("Added","addContact: Updated Added");
		db.close();

	}
	public Contact getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(Util.TABLE_NAME,new String[]{Util.KEY_ID,Util.KEY_NAME,Util.KEY_PHONE_NUMBER},
				Util.KEY_ID + "=?",new String[]{String.valueOf(id)},null,null,null);
		if (cursor != null)
			cursor.moveToFirst();
		Contact contact = new Contact();
		assert cursor != null;
		contact.setId(Integer.parseInt(cursor.getString(0)));
		contact.setName(cursor.getString(1));
		contact.setPhoneNumber(cursor.getString(2));
		return contact;
	}
	public List<Contact> getAllContact() {
		List<Contact> contactList = new ArrayList<>();
		SQLiteDatabase db = this.getReadableDatabase();
		String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
		Cursor cursor = db.rawQuery(selectAll,null);
		if (cursor.moveToNext()) {
			do {
				Contact contact = new Contact();
				contact.setId(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setPhoneNumber(cursor.getString(2));
				contactList.add(contact);

			} while (cursor.moveToNext());
		}
		return contactList;
	}
public int getCount(){
		String select = "SELECT * FROM "+ Util.TABLE_NAME +"";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(select, null);
		return cursor.getCount();
}

}
