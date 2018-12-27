package com.spider.saliya.retrofittwo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.View;
import android.widget.Toast;

import com.spider.saliya.retrofittwo.Adapters.GetAdapter;
import com.spider.saliya.retrofittwo.ApiClass.RetrofitClient;
import com.spider.saliya.retrofittwo.Bean.BeanResponce;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    GetAdapter getAdapter;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        loadItems();


    }

    private void loadItems() {

        retrofit2.Call<List<BeanResponce>> beanResponceCall = RetrofitClient
                .getRetrofitClient()
                .apiInterface().getDetails();

        beanResponceCall.enqueue(new Callback<List<BeanResponce>>() {
            @Override
            public void onResponse(retrofit2.Call<List<BeanResponce>> call, Response<List<BeanResponce>> response) {

                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();

                List<BeanResponce> beanResponces = response.body();
                getAdapter = new GetAdapter(MainActivity.this, beanResponces);
                recyclerView.setAdapter(getAdapter);
            }

            @Override
            public void onFailure(retrofit2.Call<List<BeanResponce>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
