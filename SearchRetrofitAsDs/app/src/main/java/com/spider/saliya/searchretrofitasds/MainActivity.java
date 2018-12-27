package com.spider.saliya.searchretrofitasds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.spider.saliya.searchretrofitasds.Adapter.RecycAdapter;
import com.spider.saliya.searchretrofitasds.ApiClass.ApiClient;
import com.spider.saliya.searchretrofitasds.Bean.DogsBreeds;
import com.spider.saliya.searchretrofitasds.Bean.Message;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    RecycAdapter recycAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);


        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);


        Loaditem();


    }

    private void Loaditem() {

        Call<DogsBreeds> dogsBreedsCall = ApiClient
                .getApiClient()
                .apiInterface()
                .getmessage();

        dogsBreedsCall.enqueue(new Callback<DogsBreeds>() {
            @Override
            public void onResponse(Call<DogsBreeds> call, Response<DogsBreeds> response) {

                DogsBreeds dogsBreeds = response.body();
                recycAdapter = new RecycAdapter(MainActivity.this, dogsBreeds);
                recyclerview.setAdapter(recycAdapter);

            }

            @Override
            public void onFailure(Call<DogsBreeds> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
