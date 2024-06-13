package com.cookandroid.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.main);

        Button checkButton = findViewById(R.id.button_check);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheckActivity.class);
                startActivity(intent);
            }
        });

        Button inputButton = findViewById(R.id.button_input);
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputCheckupActivity.class);
                startActivity(intent);
            }
        });

        Button outputButton = findViewById(R.id.button_output);
        outputButton.setOnClickListener(new View.OnClickListener() {
=======
        setContentView(R.layout.main); // main.xml 파일이 존재하는지 확인
        // 지도 버튼 클릭 리스너
        Button mapButton = findViewById(R.id.button_map); // button_checkup_list의 ID를 확인
        mapButton.setOnClickListener(new View.OnClickListener() { // setOnClickListener 메서드를 인식하도록 수정
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        // 건강검진내역 버튼 클릭 리스너
        Button checkupListButton = findViewById(R.id.button_checkup_list); // button_checkup_list의 ID를 확인
        checkupListButton.setOnClickListener(new View.OnClickListener() { // setOnClickListener 메서드를 인식하도록 수정
>>>>>>> 2f0a6f0df83cfe68f9917df75ebe05a8dc644e42
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheckupListActivity.class);
                startActivity(intent);
            }
        });
<<<<<<< HEAD
=======

        // 생활 건강 체크리스트 버튼 클릭 리스너
        Button checkListButton = findViewById(R.id.button_check); // button_check의 ID를 확인
        checkListButton.setOnClickListener(new View.OnClickListener() { // setOnClickListener 메서드를 인식하도록 수정
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CheckActivity.class);
                startActivity(intent);
            }
        });
>>>>>>> 2f0a6f0df83cfe68f9917df75ebe05a8dc644e42
    }
}
