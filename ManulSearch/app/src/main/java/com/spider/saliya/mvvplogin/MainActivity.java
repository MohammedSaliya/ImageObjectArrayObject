package com.spider.saliya.mvvplogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    SearchView searchview;
    ListView listviewe;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchview = findViewById(R.id.searchview);
        listviewe = findViewById(R.id.listviewe);

        final ArrayList arrayList = new ArrayList();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Pineapple");
        arrayList.add("Orange");
        arrayList.add("Lychee");
        arrayList.add("Gavava");
        arrayList.add("Peech");
        arrayList.add("Melon");
        arrayList.add("Watermelon");
        arrayList.add("Papaya");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listviewe.setAdapter(adapter);

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (arrayList.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    Toast.makeText(MainActivity.this, "No Match found", Toast.LENGTH_LONG).show();
                }
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }


}
