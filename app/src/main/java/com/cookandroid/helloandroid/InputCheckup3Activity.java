package com.cookandroid.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.helloandroid.model.Checkup;
import com.cookandroid.helloandroid.retrofit.CheckupAPI;
import com.cookandroid.helloandroid.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InputCheckup3Activity extends AppCompatActivity {
    private static final String TAG = "InputCheckup3Activity";

    private RadioGroup radioGroupChest;
    private RadioButton radioChestEtc;
    private EditText inputChestEtc;
    private Button buttonPrevious;
    private Button buttonSave; // 전역 변수로 선언
    private int bloodsugarValue,hemoglobinValue,cholesterol, fat, highCholesterol, lowCholesterol, creatinine, gfr, ast, alt, gpt,  height, weight, bodyMass, waist, sight, hearing, pressure;

    private String checkupDate, checkupHospital;
    private EditText medicine,medicalHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_checkup3);

        try {
            initializeComponents();
        } catch (Exception e) {
            Log.e(TAG, "Error during initialization: " + e.getMessage(), e);
            Toast.makeText(this, "Initialization error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void initializeComponents() throws Exception {
        RetrofitService retrofitService = new RetrofitService();
        CheckupAPI checkupAPI = retrofitService.getRetrofit().create(CheckupAPI.class);

        radioGroupChest = findViewById(R.id.radioGroup_chest);
        radioChestEtc = findViewById(R.id.radio_chest_etc);
        inputChestEtc = findViewById(R.id.input_chest_etc);
        buttonPrevious = findViewById(R.id.buttonPrevious);
        buttonSave = findViewById(R.id.button5); // 초기화

        // 자식 레이아웃을 메모리에 로드
        LayoutInflater inflater = LayoutInflater.from(this);
        ;
        View includedLayout2 = inflater.inflate(R.layout.input_checkup, null);

        // 자식 레이아웃에서 뷰 초기화
        Intent intent = getIntent();

        if (intent != null) {
            hemoglobinValue = intent.getIntExtra("hemoglobin", 0);
            bloodsugarValue = intent.getIntExtra("bloodsugar", 0);
            cholesterol = intent.getIntExtra("cholesterol", 0);
            fat=intent.getIntExtra("fat", 0);
            highCholesterol =intent.getIntExtra("highCholesterol", 0);
            lowCholesterol =intent.getIntExtra("lowCholesterol", 0);
            creatinine=intent.getIntExtra("creatine", 0);
            gfr=intent.getIntExtra("gfr", 0);
            ast=intent.getIntExtra("ast", 0);
            alt=intent.getIntExtra("alt", 0);
            gpt=intent.getIntExtra("gpt", 0);
            checkupDate=intent.getStringExtra("checkupDate");
            checkupHospital=intent.getStringExtra("checkupHospital");
            height=intent.getIntExtra("height", 0);
            weight=intent.getIntExtra("weight", 0);
            bodyMass=intent.getIntExtra("bodyMass", 0);
            waist=intent.getIntExtra("waist", 0);
            sight=intent.getIntExtra("sight", 0);
            hearing=intent.getIntExtra("hearing", 0);
            pressure=intent.getIntExtra("pressure", 0);

        }



        medicine = findViewById(R.id.input_medicalHistory);
        medicalHistory=findViewById(R.id.input_medicalHistory);


        // View 초기화 확인 로그 추가
        Log.d(TAG, "Initializing views");

        if (checkupDate == null) Log.e(TAG, "checkupDate is null");
        if (checkupHospital == null) Log.e(TAG, "checkupHospital is null");

        if (medicine == null) Log.e(TAG, "medicine is null");

        radioGroupChest.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_chest_etc) {
                    inputChestEtc.setVisibility(View.VISIBLE);
                } else {
                    inputChestEtc.setVisibility(View.GONE);
                }
            }
        });

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputCheckup3Activity.this, InputCheckup2Activity.class);
                startActivity(intent);
            }
        });

        // 저장 버튼 클릭 리스너 설정
        buttonSave.setOnClickListener(view -> {
            try {

                String inputmedicine = String.valueOf(medicine.getText());
                String inputmedicalHistory=String.valueOf(medicalHistory.getText());



                // 로그 추가하여 값 확인
                Log.d(TAG, "Medicine: " + inputmedicine);
                Log.d(TAG, "Hospital: " + checkupHospital);
                Log.d(TAG, "Checkup Date: " + checkupDate);
                Log.d(TAG, "Hemoglobin: " + hemoglobinValue);
                Log.d(TAG, "Bloodsugar: " + hemoglobinValue);
                Log.d(TAG, "Height: " + height);
                Log.d(TAG, "Weight: " + weight);
                Log.d(TAG, "Body Mass: " + bodyMass);
                Log.d(TAG, "Waist: " + waist);
                Log.d(TAG, "Sight: " + sight);
                Log.d(TAG, "Hearing: " +hearing);
                Log.d(TAG, "Pressure: " + pressure);
                Log.d(TAG, "Cholesterol: " + cholesterol);
                Log.d(TAG, "Fat: " + fat);
                Log.d(TAG, "High Cholesterol: " + highCholesterol);
                Log.d(TAG, "Low Cholesterol: " + lowCholesterol);
                Log.d(TAG, "Creatinine: " + creatinine);
                Log.d(TAG, "GFR: " + gfr);
                Log.d(TAG, "AST: " + ast);
                Log.d(TAG, "ALT: " + alt);
                Log.d(TAG, "GPT: " + gpt);

                Checkup checkup = new Checkup();
                checkup.setHospital(checkupHospital);
                checkup.setAlt(alt);
                checkup.setAst(ast);
                checkup.setMedicine(inputmedicine);
                checkup.setBloodsugar(bloodsugarValue);
                checkup.setHeight(height);
                checkup.setHemoglobin(hemoglobinValue);
                checkup.setWeight(weight);
                checkup.setBodyMass(bodyMass);
                checkup.setWaist(waist);
                checkup.setSight(sight);
                checkup.setHearing(hearing);
                checkup.setPressure(pressure);
                checkup.setCholesterol(cholesterol);
                checkup.setFat(fat);
                checkup.setHigh_cholesterol(highCholesterol);
                checkup.setLow_cholesterol(lowCholesterol);
                checkup.setCreatinine(creatinine);
                checkup.setGfr(gfr);
                checkup.setGpt(gpt);
                checkup.setDate(checkupDate);
                checkup.setMedicalHistory(inputmedicalHistory);


                checkupAPI.save(checkup).enqueue(new Callback<Checkup>() {
                    @Override
                    public void onResponse(Call<Checkup> call, Response<Checkup> response) {
                        if (response.isSuccessful()) {
                            // 저장이 되었다면
                            Toast.makeText(InputCheckup3Activity.this, "Save Success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(InputCheckup3Activity.this, HomeActivity.class);
                            startActivity(intent);
                            finish(); // 현재 액티비티를 종료하여 뒤로가기 버튼을 누르면 이전으로 돌아가지 않도록 함
                        } else {
                            // 저장이 실패했다면
                            Toast.makeText(InputCheckup3Activity.this, "Save failed", Toast.LENGTH_LONG).show();
                            Log.e(TAG, "Save failed with response code: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Checkup> call, Throwable t) {
                        // 저장이 실패했다면
                        Toast.makeText(InputCheckup3Activity.this, "Save failed", Toast.LENGTH_LONG).show();
                        Log.e(TAG, "Error occurred: " + t.getMessage(), t);
                    }
                });

            } catch (NumberFormatException e) {
                Toast.makeText(InputCheckup3Activity.this, "Invalid input. Please check your data.", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Invalid input: " + e.getMessage(), e);
            } catch (Exception e) {
                Toast.makeText(InputCheckup3Activity.this, "An error occurred: " + e.getMessage(), Toast.LENGTH_LONG).show();
                Log.e(TAG, "An error occurred: " + e.getMessage(), e);
            }
        });

    }
}
