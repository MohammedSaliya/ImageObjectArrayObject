package com.spider.saliya.getapirecycview.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spider.saliya.getapirecycview.Bean.Employee;
import com.spider.saliya.getapirecycview.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.GetViewHolder> {

    private Context context;
    private List<Employee> employee;

    public RecyclerViewAdapter(Context context, List<Employee> employee) {
        this.context = context;
        this.employee = employee;
    }

    @NonNull
    @Override
    public GetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_activity, viewGroup, false);
        return new GetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetViewHolder getViewHolder, int i) {
        getViewHolder.name.setText(employee.get(i).getEmployeeName());

    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    public class GetViewHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public GetViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
