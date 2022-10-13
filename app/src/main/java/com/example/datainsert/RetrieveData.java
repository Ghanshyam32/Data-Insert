package com.example.datainsert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetrieveData extends AppCompatActivity {

    DatabaseReference studentDb;
    ListView myListView;
    List<Students> studentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data);


        myListView= findViewById(R.id.myListView);
        studentsList = new ArrayList<>();

        studentDb = FirebaseDatabase.getInstance().getReference("students");

        studentDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentsList.clear();

                for(DataSnapshot studentData : snapshot.getChildren()){
                    Students students = studentData.getValue(Students.class);
                    studentsList.add(students);
                }

                ListAdapter adapter = new listAdapter(RetrieveData.this, studentsList);
                myListView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

}}