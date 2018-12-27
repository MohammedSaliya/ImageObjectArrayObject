package com.example.star.sumloginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.star.sumloginregister.APIClasss.APIClient;
import com.example.star.sumloginregister.Bean.SendNumber;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText number;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        number = findViewById(R.id.number);

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = number.getText().toString().trim();

                SendingNumber(mobile);

                Intent intent = new Intent(LoginActivity.this, OTPActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);


            }
        });

    }

    private void SendingNumber(String mobile) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("mobile", mobile);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<SendNumber> sendNumberCall = APIClient
                .getApiClient()
                .apiInterface()
                .getotp(jsonObject.toString());

        sendNumberCall.enqueue(new Callback<SendNumber>() {
            @Override
            public void onResponse(Call<SendNumber> call, Response<SendNumber> response) {
                SendNumber sendNumber = response.body();

                Toast.makeText(LoginActivity.this, sendNumber.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SendNumber> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
