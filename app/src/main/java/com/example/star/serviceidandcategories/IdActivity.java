package com.example.star.serviceidandcategories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.star.serviceidandcategories.APICLass.APIClient;
import com.example.star.serviceidandcategories.Adapter.AdapterView;
import com.example.star.serviceidandcategories.Bean.ServiceId;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IdActivity extends AppCompatActivity {

    ServiceId serviceId;
    RecyclerView recyclerview;

    AdapterView adapterview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);

        Showdata();

    }

    private void Showdata() {

        final Call<ServiceId> serviceIdCall = APIClient
                .getApiClient()
                .getapiInterface()
                .getService();


        serviceIdCall.enqueue(new Callback<ServiceId>() {
            @Override
            public void onResponse(Call<ServiceId> call, Response<ServiceId> response) {

                serviceId = response.body();

                adapterview = new AdapterView(IdActivity.this, serviceId);




                recyclerview.setAdapter(adapterview);

            }


            @Override
            public void onFailure(Call<ServiceId> call, Throwable t) {
                Toast.makeText(IdActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
