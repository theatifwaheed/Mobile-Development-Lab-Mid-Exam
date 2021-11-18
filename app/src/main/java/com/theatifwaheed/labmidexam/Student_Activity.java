package com.theatifwaheed.labmidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Student_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        TextView tv_ShowStdName;

        tv_ShowStdName = findViewById(R.id.tv_showStdName);

        Intent gData = getIntent();

        String n = gData.getStringExtra("name");

        tv_ShowStdName.setText(n);
    }
}