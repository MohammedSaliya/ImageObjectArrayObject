package com.spider.saliya.searchretrofitasds.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spider.saliya.searchretrofitasds.Bean.DogsBreeds;
import com.spider.saliya.searchretrofitasds.Bean.Message;
import com.spider.saliya.searchretrofitasds.R;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.GetViewholder> {


    private Context context;
    private DogsBreeds dogsBreeds;

    public RecycAdapter(Context context, DogsBreeds dogsBreeds) {
        this.context = context;
        this.dogsBreeds = dogsBreeds;
    }

    @NonNull
    @Override
    public RecycAdapter.GetViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_activity, viewGroup, false);

        return new GetViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycAdapter.GetViewholder getViewholder, int i) {


        getViewholder.textview.setText(dogsBreeds.getMessage().getBulldog().get(i));

    }

    @Override
    public int getItemCount() {
        return dogsBreeds.getMessage().getBulldog().size();
    }

    public class GetViewholder extends RecyclerView.ViewHolder {
        private TextView textview;

        public GetViewholder(@NonNull View itemView) {
            super(itemView);

            textview = itemView.findViewById(R.id.textview);
        }
    }
}
