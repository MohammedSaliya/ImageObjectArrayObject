package com.spider.saliya.retrofitone.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.spider.saliya.retrofitone.Adapters.GetAdapter;
import com.spider.saliya.retrofitone.ApiClasses.RetrofitClient;
import com.spider.saliya.retrofitone.Bean.BeanItem;
import com.spider.saliya.retrofitone.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GetAdapter getAdapter;
    ProgressDialog progressDialog;
    List<BeanItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Looading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadItems();
    }

    private void loadItems() {

        Call<List<BeanItem>> call = RetrofitClient
                .getRetrofitClient()
                .getApi()
                .getItems();

        call.enqueue(new Callback<List<BeanItem>>() {
            @Override
            public void onResponse(Call<List<BeanItem>> call, Response<List<BeanItem>> response) {
                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();

                itemList = response.body();

                getAdapter = new GetAdapter(MainActivity.this, itemList);

                recyclerView.setAdapter(getAdapter);
            }

            @Override
            public void onFailure(Call<List<BeanItem>> call, Throwable t) {

                progressDialog.dismiss();

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
