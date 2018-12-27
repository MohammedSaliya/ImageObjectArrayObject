package com.spider.saliya.spinnerretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.spider.saliya.spinnerretrofit.ApiClass.ApiClient;
import com.spider.saliya.spinnerretrofit.Bean.Example;
import com.spider.saliya.spinnerretrofit.Bean.PostResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    String selectedItem, problem_type = "2", mobile = "9618715389", booked_date = "23-11-2018", userid = "2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        LoadItem();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedItem = parent.getItemAtPosition(position).toString(); //this is your selected item

                if (position != 0) {
                    putResponse();
                }

                // Toast.makeText(MainActivity.this, "you have selected item: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void putResponse() {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("problem_reported", selectedItem);
            jsonObject.put("problem_type", problem_type);
            jsonObject.put("mobile", mobile);
            jsonObject.put("booked_date", booked_date);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<PostResponse> call = ApiClient
                .getApiClient()
                .apiInterface()
                .getResponceDetail(jsonObject.toString());

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                PostResponse getResponce = response.body();

                Toast.makeText(MainActivity.this, getResponce.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


    private void LoadItem() {

        Call<Example> listCall = ApiClient.getApiClient().apiInterface().getdata();

        listCall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                Example example = response.body();

                ArrayList<String> arrayList = new ArrayList<>();

                arrayList.add("Please select your problem");

                for (int i = 0; i < example.getDataList().size(); i++) {
                    String name = example.getDataList().get(i).getName();

                    arrayList.add(name);
                }

                spinner.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList));

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
