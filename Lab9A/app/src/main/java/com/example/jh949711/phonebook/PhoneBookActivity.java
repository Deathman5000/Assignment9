package com.example.jh949711.phonebook;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneBookActivity extends AppCompatActivity {

    EditText firstName, lastName, phoneNumber;
    Button addButton, deleteButton, showAllButton, clearFieldButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);
        addButton = findViewById(R.id.add);
        deleteButton = findViewById(R.id.delete);
        showAllButton = findViewById(R.id.showAll);
        clearFieldButton = findViewById(R.id.clearField);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeCall makeCall = new MakeCall(firstName.getText().toString(),
                        lastName.getText().toString(), phoneNumber.getText().toString());
                ContentValues values = new ContentValues();


            }
        });
    }

    public void show(View view){
        firstName.setText("");
        lastName.setText("");
        firstName.requestFocus();
        Intent intent = new Intent(this, DisplayActivity.class);
    }

}
