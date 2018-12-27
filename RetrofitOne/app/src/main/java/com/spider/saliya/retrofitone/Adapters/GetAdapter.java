package com.spider.saliya.retrofitone.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spider.saliya.retrofitone.Activities.MainActivity;
import com.spider.saliya.retrofitone.Bean.BeanItem;
import com.spider.saliya.retrofitone.R;

import java.util.List;

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.GetViewHolder> {

    private Context context;

    private List<BeanItem> itemList;

    public GetAdapter(Context context, List<BeanItem> itemList) {
        this.context = context;
        this.itemList = itemList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public GetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_view, viewGroup,false);
        return new GetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetViewHolder getViewHolder, int i) {

        getViewHolder.name.setText(itemList.get(i).getName());
        getViewHolder.realname.setText(itemList.get(i).getRealname());
        getViewHolder.team.setText(itemList.get(i).getTeam());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class GetViewHolder extends RecyclerView.ViewHolder{

        public TextView name, realname, team;

        public GetViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            realname=itemView.findViewById(R.id.realname);
            team=itemView.findViewById(R.id.team);
        }
    }
}
