package com.example.star.exampleloginotp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.star.exampleloginotp.ApiClass.ApiClient;
import com.example.star.exampleloginotp.Bean.CheckOtp;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPActivity extends AppCompatActivity {

    EditText otp;
    Button submit;

    String mobile;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Please wait...");


        Intent intent = getIntent();
        mobile = intent.getStringExtra("mobile");

        otp = findViewById(R.id.otp);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String otpNo = otp.getText().toString().trim();
                Intent intent1 = new Intent(getApplicationContext(), NextActivity.class);
                startActivity(intent1);
                checkApi(otpNo, mobile);
            }
        });


    }

    private void checkApi(String otpNo, String mobile) {


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("otp", otpNo);
            jsonObject.put("mobile", mobile);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<CheckOtp> checkOtpCall = ApiClient
                .apiClient()
                .apiInterface()
                .getcheckOtp(jsonObject.toString());


        checkOtpCall.enqueue(new Callback<CheckOtp>() {
            @Override
            public void onResponse(Call<CheckOtp> call, Response<CheckOtp> response) {
                progressDialog.dismiss();

                CheckOtp checkOtp = response.body();

                Toast.makeText(OTPActivity.this, checkOtp.getMessage(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<CheckOtp> call, Throwable t) {

                Toast.makeText(OTPActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}

