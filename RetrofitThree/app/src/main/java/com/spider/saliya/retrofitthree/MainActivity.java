package com.spider.saliya.retrofitthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.spider.saliya.retrofitthree.ApiClass.ApiClient;
import com.spider.saliya.retrofitthree.Bean.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Spinner spinner, spinnerone, spinnercity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinnerone = findViewById(R.id.spinnerone);
        spinnercity = findViewById(R.id.spinnercity);

        loadSpinner();

    }

    private void loadSpinner() {

        Call<List<Example>> call = ApiClient
                .getApiClient()
                .api()
                .getlist();

        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();

                List<Example> spinnerNameList = response.body();

                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayListusername = new ArrayList<>();
                ArrayList<String> arrayaddress = new ArrayList<>();

                for (int i = 0; i < spinnerNameList.size(); i++) {

                    String name = spinnerNameList.get(i).getName();
                    String username = spinnerNameList.get(i).getUsername();
                    String Address = spinnerNameList.get(i).getAddress().getCity();

                    arrayList.add(name);
                    arrayListusername.add(username);
                    arrayaddress.add(Address);

                }

                spinner.setAdapter
                        (new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList));
                spinnerone.setAdapter
                        (new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayListusername));

                spinnercity.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayaddress));
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
