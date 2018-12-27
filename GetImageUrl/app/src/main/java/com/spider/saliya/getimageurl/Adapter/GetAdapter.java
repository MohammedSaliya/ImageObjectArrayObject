package com.spider.saliya.getimageurl.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.spider.saliya.getimageurl.Bean.Responce;
import com.spider.saliya.getimageurl.R;

import java.util.List;

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.GetViewHolder> {

    private Context context;
    private List<Responce> responceList;

    public GetAdapter(Context context, List<Responce> responceList) {
        this.context = context;
        this.responceList = responceList;
    }

    @NonNull
    @Override
    public GetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.load_activicty, viewGroup, false);
        return new GetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetViewHolder getViewHolder, int i) {
        getViewHolder.name.setText(responceList.get(i).getName());
        getViewHolder.username.setText(responceList.get(i).getRealname());

        Glide
                .with(context)
                .load(responceList.get(i).getImageurl())
                .into(getViewHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return responceList.size();
    }

    public class GetViewHolder extends RecyclerView.ViewHolder {

         TextView name, username;
         ImageView imageView;

        public GetViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}
