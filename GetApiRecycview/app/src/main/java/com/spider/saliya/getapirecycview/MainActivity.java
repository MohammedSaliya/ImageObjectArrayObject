package com.spider.saliya.getapirecycview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.spider.saliya.getapirecycview.Adapter.RecyclerViewAdapter;
import com.spider.saliya.getapirecycview.ApiClass.ApiClient;
import com.spider.saliya.getapirecycview.Bean.Employee;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    EditText inputSearch;
    RecyclerViewAdapter RecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);


        LodingItem();

     /*   inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
               *//* MainActivity.this.adapter.getFilter().filter(cs);*//*
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub


            }


        });*/


    }

    private void LodingItem() {

        Call<List<Employee>> call = ApiClient
                .apiClient()
                .apiInterface()
                .getemployee();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                List<Employee> employees = response.body();


                RecyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, employees);
                recyclerview.setAdapter(RecyclerViewAdapter);
                Toast.makeText(MainActivity.this, "" + employees.size(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    }

