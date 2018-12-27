package com.example.star.exampleloginotp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.star.exampleloginotp.ApiClass.ApiClient;
import com.example.star.exampleloginotp.Bean.OtpSend;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText mobilenumber;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobilenumber = findViewById(R.id.mobilenumber);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {

                                         String mobile = mobilenumber.getText().toString().trim();
                                         getmobilenumber(mobile);

                                         Intent intent = new Intent(getApplicationContext(), OTPActivity.class);
                                         intent.putExtra("mobile", mobile);
                                         startActivity(intent);
                                     }
                                 }
        );

    }

    private void getmobilenumber(String mobile) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("mobile", mobile);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final Call<OtpSend> otpSendCall = ApiClient
                .apiClient()
                .apiInterface()
                .getotp(jsonObject.toString());


        otpSendCall.enqueue(new Callback<OtpSend>() {
            @Override
            public void onResponse(Call<OtpSend> call, Response<OtpSend> response) {
                OtpSend otpSend = response.body();

                Toast.makeText(LoginActivity.this, otpSend.getMessage(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<OtpSend> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


}
