package com.spider.saliya.retrofirlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spider.saliya.retrofirlogin.ApiClass.ApiClient;
import com.spider.saliya.retrofirlogin.Bean.GetMobileNumber;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText mobilenumber;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobilenumber = findViewById(R.id.mobilenumber);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = mobilenumber.getText().toString().trim();


                getmobileno(mobile);

                Intent intent = new Intent(MainActivity.this, CheckOtpActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);

            }
        });


    }

    private void getmobileno(String mobile) {


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("mobile", mobile);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<GetMobileNumber> getMobileNumberCall = ApiClient
                .getapiClient()
                .apiInterface()
                .getotp(jsonObject.toString());


        getMobileNumberCall.enqueue(new Callback<GetMobileNumber>() {

            @Override
            public void onResponse(Call<GetMobileNumber> call, Response<GetMobileNumber> response) {

                GetMobileNumber getMobileNumber = response.body();


                Toast.makeText(MainActivity.this, getMobileNumber.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<GetMobileNumber> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}

