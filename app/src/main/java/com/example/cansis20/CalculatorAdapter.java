package com.example.cansis20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.ViewHolder> {
    private List<CalculatorGetterSetter> listData;
    public CalculatorAdapter(List<CalculatorGetterSetter> list) {
        this.listData = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.calculator_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.subjectName.setText(listData.get(position).getSubject());
        holder.creditScore.setText(String.valueOf(listData.get(position).getCreditScore()));


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    public class ViewHolder extends   RecyclerView.ViewHolder{
        private TextView subjectName,creditScore;
        public ViewHolder(View itemview) {
            super(itemview);
            subjectName = itemview.findViewById(R.id.subjectTxt);
            creditScore = itemview.findViewById(R.id.creditTxt);



        }
    }
}
