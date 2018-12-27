package com.example.star.sumretrofit.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.star.sumretrofit.Bean.DataModule;
import com.example.star.sumretrofit.R;

import java.util.List;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.getViewHolder> {

    private Context context;
    private List<DataModule> data;

    public RecycAdapter(Context context, List<DataModule> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecycAdapter.getViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_view, viewGroup, false);
        return new getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycAdapter.getViewHolder getViewHolder, int i) {
        getViewHolder.name.setText(data.get(i).getName());
        getViewHolder.realname.setText(data.get(i).getRealname());
        getViewHolder.team.setText(data.get(i).getTeam());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class getViewHolder extends RecyclerView.ViewHolder {

        public TextView name, realname, team;

        public getViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            realname = itemView.findViewById(R.id.realname);
            team = itemView.findViewById(R.id.team);
        }
    }
}
