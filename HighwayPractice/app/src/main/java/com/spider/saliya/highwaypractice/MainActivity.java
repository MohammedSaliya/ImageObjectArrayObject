package com.spider.saliya.highwaypractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.spider.saliya.highwaypractice.Adapter.GetAdapter;
import com.spider.saliya.highwaypractice.ApiClass.ApiClient;
import com.spider.saliya.highwaypractice.Bean.RoadKeyId.BridgeKeyId.BridgeResponce;
import com.spider.saliya.highwaypractice.Bean.RoadKeyId.Linkid.Example;
import com.spider.saliya.highwaypractice.Bean.RoadKeyId.RoadKeyId.RoadResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Spinner spn_road_key_id, spn_link_id;

    RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn_road_key_id = findViewById(R.id.spn_road_key_id);

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(layoutManager);


        spn_link_id = findViewById(R.id.spn_link_id);
        loadreadkeyid();

        spn_link_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String bridgeid = parent.getItemAtPosition(position).toString();
                bridgeload(bridgeid);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spn_road_key_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String linkid = parent.getItemAtPosition(position).toString();

                loadlinkid(linkid);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


            private void loadlinkid(String linkid) {

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("road_id", linkid);
                    jsonObject.put("road_name", "");

                } catch (JSONException e) {
                    e.printStackTrace();

                }

                Call<Example> linkResponceCall = ApiClient
                        .getApiClient()
                        .apiInterface()
                        .getlinkid(jsonObject.toString());

                linkResponceCall.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        Example linkResponce = response.body();
                        ArrayList<String> linkArrayList = new ArrayList<>();

                        for (int i = 0; i < linkResponce.getResult().getData().size(); i++) {

                            String linkid = linkResponce.getResult().getData().get(i).getLINKID();

                            linkArrayList.add(linkid);
                        }

                        spn_link_id.setAdapter(new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, linkArrayList));


                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });
    }

    private void bridgeload(String bridgeid) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("link_id", bridgeid);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Call<BridgeResponce> bridgeResponceCall = ApiClient
                .getApiClient().apiInterface().getbridgeid(jsonObject.toString());

        bridgeResponceCall.enqueue(new Callback<BridgeResponce>() {
            @Override
            public void onResponse(Call<BridgeResponce> call, Response<BridgeResponce> response) {
                BridgeResponce bridgeResponce = response.body();


                GetAdapter getAdapter = new GetAdapter(bridgeResponce, MainActivity.this);
                recyclerview.setAdapter(getAdapter);

            }

            @Override
            public void onFailure(Call<BridgeResponce> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void loadreadkeyid() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("user_id", "86");
            jsonObject.put("subdivision_id", "375");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Call<RoadResponse> roadResponseCall = ApiClient
                .getApiClient()
                .apiInterface().getroadkeyid(jsonObject.toString());

        roadResponseCall.enqueue(new Callback<RoadResponse>() {
            @Override
            public void onResponse(Call<RoadResponse> call, Response<RoadResponse> response) {

                RoadResponse roadResponse = response.body();
                ArrayList<String> arrayList = new ArrayList<>();

                for (int i = 0; i < roadResponse.getResult().getData().size(); i++) {
                    String roadid = roadResponse.getResult().getData().get(i).getROADKEYID();


                    arrayList.add(roadid);

                }
                spn_road_key_id.setAdapter(new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList));


            }

            @Override
            public void onFailure(Call<RoadResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}




