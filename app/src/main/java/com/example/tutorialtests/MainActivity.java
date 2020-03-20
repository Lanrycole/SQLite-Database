package com.example.tutorialtests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.tutorialtests.Data.DatabaseHandler;
import com.example.tutorialtests.Model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Contact nike = new Contact();
		nike.setId(1);
		nike.setName("Nike");
		nike.setPhoneNumber("123456");

		Contact lanre = new Contact();
		lanre.setId(2);
		lanre.setName("Bruce");
		lanre.setPhoneNumber("0000000");

		DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);

//		databaseHandler.addContact(nike);
//		databaseHandler.addContact(lanre);

//		databaseHandler.upDateContact(lanre);


			Log.d("CONTACTS","onCreate: " + databaseHandler.getCount());


	}
}
