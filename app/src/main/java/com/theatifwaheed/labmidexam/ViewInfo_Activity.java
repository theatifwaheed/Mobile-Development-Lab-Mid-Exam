package com.theatifwaheed.labmidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewInfo_Activity extends AppCompatActivity {
    EditText et_StudentName;
    ListView lv_student;
    Button btnEnterData;
    ArrayAdapter <String> ShowStudent;
    ArrayList <String> TheAtifWaheed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);



        Intent data = getIntent();
        String name = data.getStringExtra("et_stdName");

        lv_student = findViewById(R.id.lv_students);
        btnEnterData = findViewById(R.id.btn_eData);
        et_StudentName = findViewById(R.id.et_studentName);

        TheAtifWaheed = new ArrayList<String>();

        TheAtifWaheed.add(name);

        ShowStudent = new ArrayAdapter<String>(ViewInfo_Activity.this, android.R.layout.simple_dropdown_item_1line, TheAtifWaheed);
        lv_student.setAdapter(ShowStudent);
        ShowStudent.notifyDataSetChanged();

        lv_student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent sData = new Intent(
                        ViewInfo_Activity.this, Student_Activity.class
                );
                String Name = TheAtifWaheed.get(i).toString();
                sData.putExtra("name", Name);
                startActivity(sData);
            }
        });


        btnEnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!et_StudentName.getText().toString().isEmpty()){
                    String n = et_StudentName.getText().toString();
                    et_StudentName.setText("");
                    TheAtifWaheed.add(n);
                    ShowStudent.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(et_StudentName.getText().toString().isEmpty()){
            }
        else{
            String name = et_StudentName.getText().toString();
            et_StudentName.setText("");
            TheAtifWaheed.add(name);
            ShowStudent.notifyDataSetChanged();
        }
    }
}