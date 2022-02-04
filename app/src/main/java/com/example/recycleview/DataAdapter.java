package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    ArrayList<String> dataList;

    public DataAdapter(ArrayList<String> data) {
        this.dataList = data;
    }

    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, null, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.DataViewHolder holder, int position) {
        holder.assignData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView data_field;

        public DataViewHolder(View itemView) {
            super(itemView);
            data_field = (TextView) itemView.findViewById(R.id.data_field);

        }

        public void assignData(String s) {
            data_field.setText(s);
        }
    }
}
