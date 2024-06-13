package com.cookandroid.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputCheckup2Activity extends AppCompatActivity {
    private EditText hemoglobin;
    private EditText bloodsugar;
    private EditText cholesterol, fat, highCholesterol, lowCholesterol, creatinine, gfr, ast, alt, gpt, checkupDate, checkupHospital, height, weight, bodyMass, waist, sight, hearing, pressure, medicine,medicalHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_checkup2);

        hemoglobin = findViewById(R.id.input_hemoglobin);
        bloodsugar=findViewById(R.id.input_bloodsugar);
        cholesterol = findViewById(R.id.input_cholesterol);
        fat = findViewById(R.id.input_fat);
        highCholesterol = findViewById(R.id.input_high_cholesterol);
        lowCholesterol = findViewById(R.id.input_low_cholesterol);
        creatinine = findViewById(R.id.input_creatinine);
        gfr = findViewById(R.id.input_gfr);
        ast = findViewById(R.id.input_ast);
        alt = findViewById(R.id.input_alt);
        gpt = findViewById(R.id.input_gpt);

        // 이전 액티비티로부터 전달된 인텐트를 받음
        Intent receivedIntent = getIntent();
        String checkupDate = receivedIntent.getStringExtra("checkupDate");
        String checkupHospital = receivedIntent.getStringExtra("checkupHospital");
        int height = receivedIntent.getIntExtra("height",0);
        int weight = receivedIntent.getIntExtra("weight",0);
        int bodyMass = receivedIntent.getIntExtra("bodyMass",0);
        int waist = receivedIntent.getIntExtra("waist",0);
        int sight = receivedIntent.getIntExtra("sight",0);
        int hearing = receivedIntent.getIntExtra("hearing",0);
        int pressure = receivedIntent.getIntExtra("pressure",0);



// 나머지 필드들도 같은 방식으로 추가


        // 뒤로가기 버튼 클릭 시 InputCheckupActivity로 이동
        Button buttonPrevious = findViewById(R.id.buttonPrevious);
        buttonPrevious.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(InputCheckup2Activity.this, InputCheckupActivity.class);
                startActivity(intent);
            }
        });

        // 다음으로 버튼 클릭 시 InputCheckup3Activity로 이동
        Button buttonNext = findViewById(R.id.button2);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(InputCheckup2Activity.this, InputCheckup3Activity.class);
                intent.putExtra("hemoglobin", Integer.parseInt(hemoglobin.getText().toString()));
                intent.putExtra("bloodsugar", Integer.parseInt(bloodsugar.getText().toString()));
                intent.putExtra("cholesterol", Integer.parseInt(cholesterol.getText().toString()));
                intent.putExtra("fat", Integer.parseInt(fat.getText().toString()));
                intent.putExtra("highCholesterol", Integer.parseInt(highCholesterol.getText().toString()));
                intent.putExtra("lowCholesterol", Integer.parseInt(lowCholesterol.getText().toString()));
                intent.putExtra("creatine", Integer.parseInt(creatinine.getText().toString()));
                intent.putExtra("gfr", Integer.parseInt(gfr.getText().toString()));
                intent.putExtra("ast", Integer.parseInt(ast.getText().toString()));
                intent.putExtra("alt", Integer.parseInt(alt.getText().toString()));
                intent.putExtra("gpt", Integer.parseInt(gpt.getText().toString()));
                // InputCheckupActivity에서 받은 값도 다시 전달
                intent.putExtra("checkupDate", checkupDate);
                intent.putExtra("checkupHospital", checkupHospital);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                intent.putExtra("bodyMass", bodyMass);
                intent.putExtra("waist", waist);
                intent.putExtra("sight", sight);
                intent.putExtra("hearing", hearing);
                intent.putExtra("pressure", pressure);
                startActivity(intent);

            }
        });
    }

}
