package com.spider.saliya.retrofittwo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spider.saliya.retrofittwo.Bean.BeanResponce;
import com.spider.saliya.retrofittwo.R;

import java.util.List;

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.MyViewHolder> {

    private Context context;
    private List<BeanResponce> beanResponce;


    public GetAdapter(Context context, List<BeanResponce> beanResponce) {
        this.context = context;
        this.beanResponce = beanResponce;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_card_view, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(beanResponce.get(i).getName());
       /* myViewHolder.username.setText(beanResponce.get(i).getUsername());
        myViewHolder.email.setText(beanResponce.get(i).getEmail());
        myViewHolder.phone.setText(beanResponce.get(i).getPhone());
        myViewHolder.website.setText(beanResponce.get(i).getWebsite());*/


    }

    @Override
    public int getItemCount() {
        return beanResponce.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name/*, username, email, phone, website*/;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
          /*  username = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            website = itemView.findViewById(R.id.website);
*/

        }
    }
}
