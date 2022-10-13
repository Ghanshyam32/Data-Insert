package com.example.datainsert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText roll_no;
    EditText name;
    Spinner courses;
    Button insert;
    Button dataRetrieve;


    DatabaseReference studentDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll_no = findViewById(R.id.roll);
        name = findViewById(R.id.name);
        courses = findViewById(R.id.course);
        insert = findViewById(R.id.insert);
        dataRetrieve = findViewById(R.id.retrieve);

        studentDb = FirebaseDatabase.getInstance().getReference().child("students");

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                insertData();
            }
        });

        dataRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RetrieveData.class);
            }
        });

    }

    private void insertData(){
        String stu_name = name.getText().toString();
        String stu_roll = roll_no.getText().toString();
        String course = courses.getSelectedItem().toString();

        Students students = new Students(stu_name,stu_roll,course);

        studentDb.push().setValue(students);
        Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
    }



}