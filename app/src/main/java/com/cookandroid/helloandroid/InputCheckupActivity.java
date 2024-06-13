package com.cookandroid.helloandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputCheckupActivity extends AppCompatActivity {
    private EditText cholesterol, fat, highCholesterol, lowCholesterol, creatinine, gfr, ast, alt, gpt, checkupDate, checkupHospital, height, weight, bodyMass, waist, sight, hearing, pressure, medicine,medicalHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_checkup);
        checkupDate = findViewById(R.id.input_checkupDate);
        checkupHospital = findViewById(R.id.input_checkupHospital);
        height = findViewById(R.id.input_height);
        weight = findViewById(R.id.input_weight);
        bodyMass = findViewById(R.id.input_bodyMass);
        waist = findViewById(R.id.input_waist);
        sight = findViewById(R.id.input_sight);
        hearing = findViewById(R.id.input_hearing);
        pressure = findViewById(R.id.input_pressure);


        // 다음으로 버튼 클릭 시 input_checkup2 페이지로 이동
        Button input_checkup2_btn = findViewById(R.id.input_checkup2_btn);
        input_checkup2_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(InputCheckupActivity.this, InputCheckup2Activity.class);
                intent.putExtra("checkupHospital", checkupHospital.getText().toString());
                intent.putExtra("checkupDate", checkupDate.getText().toString());
                intent.putExtra("height", Integer.parseInt(height.getText().toString()));
                intent.putExtra("weight", Integer.parseInt(weight.getText().toString()));
                intent.putExtra("bodyMass", Integer.parseInt(bodyMass.getText().toString()));
                intent.putExtra("waist", Integer.parseInt(waist.getText().toString()));
                intent.putExtra("sight", Integer.parseInt(sight.getText().toString()));
                intent.putExtra("hearing", Integer.parseInt(hearing.getText().toString()));
                intent.putExtra("pressure", Integer.parseInt(pressure.getText().toString()));

                startActivity(intent);
            }
        });

        // 등록취소하기 버튼 클릭 시 list 화면으로 이동
        Button cancelButton = findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputCheckupActivity.this, CheckupListActivity.class);


                startActivity(intent);
                finish(); // 현재 액티비티를 종료하여 백 스택에서 제거
            }
        });

    }
}