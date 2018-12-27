package com.example.star.sumloginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.star.sumloginregister.APIClasss.APIClient;
import com.example.star.sumloginregister.Bean.SendNumber;
import com.example.star.sumloginregister.Bean.SendOtp;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPActivity extends AppCompatActivity {

    EditText otp;
    Button verfied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        Intent intent = getIntent();
        final String mobile = intent.getStringExtra("mobile");


        otp = findViewById(R.id.otp);
        verfied = findViewById(R.id.verfied);

        verfied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oneotp = otp.getText().toString().trim();

                getVerfied(oneotp, mobile);
            }
        });
    }

    private void getVerfied(String mobile, String oneotp) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("mobile", mobile);
            jsonObject.put("otp", oneotp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<SendOtp> sendOtpCall = APIClient
                .getApiClient()
                .apiInterface()
                .getverfied(jsonObject.toString());

        sendOtpCall.enqueue(new Callback<SendOtp>() {
            @Override
            public void onResponse(Call<SendOtp> call, Response<SendOtp> response) {
                SendOtp sendotp = response.body();
                Toast.makeText(OTPActivity.this, sendotp.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SendOtp> call, Throwable t) {
                Toast.makeText(OTPActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
