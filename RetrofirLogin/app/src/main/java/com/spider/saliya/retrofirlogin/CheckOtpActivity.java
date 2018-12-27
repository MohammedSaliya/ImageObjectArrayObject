package com.spider.saliya.retrofirlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spider.saliya.retrofirlogin.ApiClass.ApiClient;
import com.spider.saliya.retrofirlogin.Bean.GetResponce;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckOtpActivity extends AppCompatActivity {

    EditText edt_otp;
    Button btn_otpsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_otp);

        final Intent intent = getIntent();
        final String mobile = intent.getStringExtra("mobile");

        edt_otp = findViewById(R.id.edt_otp);
        btn_otpsubmit = findViewById(R.id.btn_otpsubmit);
        btn_otpsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = edt_otp.getText().toString().trim();

                otpcheck(otp, mobile);


            }
        });
    }

    private void otpcheck(String otp, String mobile) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("mobile", mobile);
            jsonObject.put("otp", otp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<GetResponce> getResponceCall = ApiClient
                .getapiClient().apiInterface().checkotp(jsonObject.toString());

        getResponceCall.enqueue(new Callback<GetResponce>() {
            @Override
            public void onResponse(Call<GetResponce> call, Response<GetResponce> response) {

                GetResponce getResponce = response.body();
                Toast.makeText(CheckOtpActivity.this, getResponce.getLogin(), Toast.LENGTH_SHORT).show();

                if (getResponce.getSuccess()) {
                    Intent intent1 = new Intent(CheckOtpActivity.this, OtpSuccessActivity.class);
                    startActivity(intent1);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<GetResponce> call, Throwable t) {
                Toast.makeText(CheckOtpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
