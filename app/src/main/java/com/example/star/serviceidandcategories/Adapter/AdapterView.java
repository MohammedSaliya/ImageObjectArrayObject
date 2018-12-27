package com.example.star.serviceidandcategories.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.star.serviceidandcategories.Bean.ServiceId;
import com.example.star.serviceidandcategories.IdActivity;
import com.example.star.serviceidandcategories.R;

public class AdapterView extends RecyclerView.Adapter<AdapterView.GetVIewHolder> {

    ServiceId serviceId;
    IdActivity IdActivity;
    Context context;

    public AdapterView(Context context, ServiceId serviceId) {
        this.serviceId = serviceId;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterView.GetVIewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recycview, viewGroup, false);
        return new GetVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetVIewHolder getVIewHolder, int i) {
//        getVIewHolder.image.setText(serviceId.getData().get(i).getService_name());

        Glide
                .with(context)
                .load(serviceId.getData().get(i).getService_image())
                .into(getVIewHolder.image);
    }

    @Override
    public int getItemCount() {
        return serviceId.getData().size();
    }

    public class GetVIewHolder extends RecyclerView.ViewHolder {
        public ImageView image;


        public GetVIewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
        }
    }
}
