package com.example.star.sumretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.star.sumretrofit.APIClasss.APIClient;
import com.example.star.sumretrofit.Adapter.RecycAdapter;
import com.example.star.sumretrofit.Bean.DataModule;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecycAdapter recycAdapter;
    RecyclerView recyclerView;
    List<DataModule> dataModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycylerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


        dataLoad();


    }

    private void dataLoad() {

        Call<List<DataModule>> listCall = APIClient
                .getapiClient()
                .getapiInterface()
                .getresponce();

        listCall.enqueue(new Callback<List<DataModule>>() {
            @Override
            public void onResponse(Call<List<DataModule>> call, Response<List<DataModule>> response) {


                dataModules = response.body();
                recycAdapter = new RecycAdapter(MainActivity.this, dataModules);
                recyclerView.setAdapter(recycAdapter);



            }

            @Override
            public void onFailure(Call<List<DataModule>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
