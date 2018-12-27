package com.spider.saliya.retrofittwo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.spider.saliya.retrofittwo.ApiClass.RetrofitClient;
import com.spider.saliya.retrofittwo.Bean.BeanResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayActivity extends AppCompatActivity {

    TextView nameID, username, email, street, suite, city, zipcode, phone, website;

    ProgressDialog progressDialog;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        position = intent.getIntExtra("position", 0);

        nameID=findViewById(R.id.nameID);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        street=findViewById(R.id.street);
        suite=findViewById(R.id.suite);
        city=findViewById(R.id.city);
        zipcode=findViewById(R.id.zipcode);
        phone=findViewById(R.id.phone);
        website=findViewById(R.id.website);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        displayDetails();
    }

    private void displayDetails() {

        Call<List<BeanResponce>> call = RetrofitClient
                .getRetrofitClient()
                .apiInterface()
                .getDatas();

        call.enqueue(new Callback<List<BeanResponce>>() {
            @Override
            public void onResponse(Call<List<BeanResponce>> call, Response<List<BeanResponce>> response) {
                progressDialog.dismiss();

                List<BeanResponce> beanResponceList = response.body();

                nameID.setText(beanResponceList.get(position).getName());
                username.setText(beanResponceList.get(position).getUsername());
                email.setText(beanResponceList.get(position).getEmail());
                street.setText(beanResponceList.get(position).getAddress().getStreet());
                suite.setText(beanResponceList.get(position).getAddress().getSuite());
                city.setText(beanResponceList.get(position).getAddress().getCity());
                zipcode.setText(beanResponceList.get(position).getAddress().getZipcode());
                phone.setText(beanResponceList.get(position).getPhone());
                website.setText(beanResponceList.get(position).getWebsite());

            }

            @Override
            public void onFailure(Call<List<BeanResponce>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(DisplayActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
