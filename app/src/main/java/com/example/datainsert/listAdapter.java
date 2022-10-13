package com.example.datainsert;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class listAdapter extends ArrayAdapter {
    private Activity mcontxt;
    List<Students> studentsList;
    public listAdapter(Activity mcontxt, List<Students> studentsList){
        super(mcontxt, R.layout.list_item, studentsList);
        this.mcontxt = mcontxt;
        this.studentsList = studentsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mcontxt.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null, true);

        TextView name = listItemView.findViewById(R.id.name);
        TextView rollNo = listItemView.findViewById(R.id.rollNo);
        TextView course = listItemView.findViewById(R.id.course);

        Students students = studentsList.get(position);
        name.setText(students.getName());
        rollNo.setText(students.getRollNo());
        course.setText(students.getCourse());

        return listItemView;

    }
}
