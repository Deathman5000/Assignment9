package com.example.jh949711.makeacall;
/*
    This app takes the info from the PhoneBook app and the user can make a call or look up the contact.
    Authors: Kyra Belanger, James Hund
    Version: 04/21/18
    Parts worked on: We both equally worked on both files in this app.
    Grade deserved: Kyra:  100%
                    James: 100%
 */

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "firstName";
    private static final String COLUMN_LAST_NAME = "lastName";
    private static final String COLUMN_PHONE_NUMBER = "number";
    EditText fName, lName;
    Button find, call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        fName = findViewById(R.id.firstName);
        lName = findViewById(R.id.lastName);
        find = findViewById(R.id.find);
        call = findViewById(R.id.makeCall);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AUTHORITY = "com.example.jh949711.phonebook.MyContentProvider";
                String TABLE_PRODUCT = "product";
                Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" +TABLE_PRODUCT);
                ContentResolver contentResolver = getContentResolver();
                String [] projection = {COLUMN_ID, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_PHONE_NUMBER};
                Cursor cursor = contentResolver.query(CONTENT_URI,projection,null,null,null);
                String s = "";
                TextView tv = findViewById(R.id.phoneNumber);
                if (!cursor.moveToFirst()) s = "no result to display";
                else{
                    do {
                        s += String.format("%-10s\n",cursor.getString(3));
                    } while (cursor.moveToNext());
                }
                tv.setText(s);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AUTHORITY = "com.example.jh949711.phonebook.MyContentProvider";
                String TABLE_PRODUCT = "product";
                Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" +TABLE_PRODUCT);
                ContentResolver contentResolver = getContentResolver();
                String [] projection = {COLUMN_ID, COLUMN_FIRST_NAME, COLUMN_LAST_NAME, COLUMN_PHONE_NUMBER};
                Cursor cursor = contentResolver.query(CONTENT_URI,projection,null,null,null);
                String s = "";
                if (!cursor.moveToFirst()) s = "Name not in contacts";

                else{
                    String phone_number = cursor.getString(3);
                    try {
                        Uri uri = Uri.parse("tel:" + phone_number);
                        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                        Log.i("Phone Call App", phone_number);
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "Application failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
