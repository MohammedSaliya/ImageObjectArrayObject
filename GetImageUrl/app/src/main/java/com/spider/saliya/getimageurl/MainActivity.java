package com.spider.saliya.getimageurl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Toast;

import com.spider.saliya.getimageurl.APIClass.APIClient;
import com.spider.saliya.getimageurl.APIClass.APInterface;
import com.spider.saliya.getimageurl.Adapter.GetAdapter;
import com.spider.saliya.getimageurl.Bean.Responce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    List<Responce> responces;
    GetAdapter getAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);

        LoadItem();

    }

    private void LoadItem() {

        Call<List<Responce>> linkResponceCall = APIClient
                .getapiClient()
                .getapiInterface()
                .getresponce();

        linkResponceCall.enqueue(new Callback<List<Responce>>() {
            @Override
            public void onResponse(Call<List<Responce>> call, Response<List<Responce>> response) {

                List<Responce> responces = response.body();

                getAdapter = new GetAdapter(MainActivity.this, responces);

                recyclerview.setAdapter(getAdapter);
                Toast.makeText(MainActivity.this, " Tottal " + responces.size(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<List<Responce>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
