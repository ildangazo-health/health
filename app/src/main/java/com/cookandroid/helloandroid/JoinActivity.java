package com.cookandroid.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.helloandroid.model.User;
import com.cookandroid.helloandroid.retrofit.RetrofitService;
import com.cookandroid.helloandroid.retrofit.UserAPI;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        initializeComponents();
    }
    private void initializeComponents(){
        EditText inputEditID=findViewById(R.id.editText_id);
        EditText inputEditPassword=findViewById(R.id.editText_id);
        EditText inputEditEmail=findViewById(R.id.editText_email);


        Button buttonSave=findViewById(R.id.button_join);


        RetrofitService retrofitService=new RetrofitService();
        UserAPI userAPI=retrofitService.getRetrofit().create(UserAPI.class);

        buttonSave.setOnClickListener(view -> {
            String id = String.valueOf(inputEditID.getText());
            String password = String.valueOf(inputEditPassword.getText());
            String email = String.valueOf(inputEditEmail.getText());


            User user=new User();
            user.setId(id);
            user.setPassword(password);
            user.setEmail(email);


            userAPI.save(user)
                    .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) { // 저장이 되었다면
                            Toast.makeText(JoinActivity.this, "Save Success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(JoinActivity.this, JoinActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) { // 저장이 실패했다면
                            Toast.makeText(JoinActivity.this, "Save failed", Toast.LENGTH_LONG).show();
                            Logger.getLogger(JoinActivity.class.getName()).log(Level.SEVERE, "Error occurred" + t.getMessage(), t);
                        }
                    });




        });




    }
}