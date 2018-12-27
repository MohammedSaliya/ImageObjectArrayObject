package com.spider.saliya.highwaypractice.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spider.saliya.highwaypractice.Bean.RoadKeyId.BridgeKeyId.BridgeResponce;
import com.spider.saliya.highwaypractice.MainActivity;
import com.spider.saliya.highwaypractice.R;

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.GetViewHolder> {

    private BridgeResponce bridgeResponce;
    private Context context;

    public GetAdapter(BridgeResponce bridgeResponce, Context context) {
        this.bridgeResponce = bridgeResponce;
        this.context = context;
    }

    @NonNull
    @Override
    public GetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_view, viewGroup, false);
        return new GetViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GetViewHolder getViewHolder, int i) {

        getViewHolder.bridge.setText(bridgeResponce.getResult().getData().get(i).getBRIDGEKEYID());

    }

    @Override
    public int getItemCount() {
        return bridgeResponce.getResult().getData().size();
    }

    public class GetViewHolder extends RecyclerView.ViewHolder {

        public TextView bridge;

        public GetViewHolder(@NonNull View itemView) {
            super(itemView);

            bridge = itemView.findViewById(R.id.bridge);
        }


    }
}
