package com.theatifwaheed.labmidexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class SaveInfo_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_info);


        Button btn_entData, btn_vData;
        EditText et_stdName;



        Intent sendData = new Intent(SaveInfo_Activity.this, ViewInfo_Activity.class);


        btn_entData = findViewById(R.id.btn_enterData);
        et_stdName = findViewById(R.id.et_stdName);
        btn_vData = findViewById(R.id.btn_viewData);

        loadAnimation(btn_entData);

        btn_entData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entered = et_stdName.getText().toString();
                sendData.putExtra("et_stdName", entered);
                et_stdName.setText("");
            }
        });

        btn_vData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(sendData);
            }
        });

    }
    protected void loadAnimation(Button btn){
        Animation animateButton = AnimationUtils.loadAnimation(SaveInfo_Activity.this, R.anim.rotate_enter_data);
        btn.startAnimation(animateButton);
    }
}