package com.example.cansis20;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.List;

public class MarksAdapter extends RecyclerView.Adapter<MarksAdapter.MarksViewHolder> {

    private List<String> sujectName;
    private List<Integer> totalMakrs,maxMarks;
    private List<String> grade;
    private  int indicator = 0;
    private LayoutInflater inflater;
    public MarksAdapter(Context context, List<String> subjectName,  List<Integer> maxMarks ,List<Integer> totalMakrs) {

        this.sujectName = subjectName;
       this.maxMarks = maxMarks;
       this.totalMakrs = totalMakrs;
        this.inflater = LayoutInflater.from(context);
    }

    public MarksAdapter(Context context, List<String> subjectName,  List<String> grade ,List<Integer> totalMakrs,int indicate) {

        this.sujectName = subjectName;
        this.grade = grade;
        this.totalMakrs = totalMakrs;
        this.indicator = indicate;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MarksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_marks,parent,false);

        return new MarksViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MarksViewHolder holder, int position) {
holder.subject_name.setText(sujectName.get(position));

if(indicator == 1) {
        holder.max_marks.setText("Grade : "+grade.get(position));
        holder.total_marks.setText("No-of-Attempts : "+totalMakrs.get(position).toString());
}else {
    holder.max_marks.setText("Max Mark : " + maxMarks.get(position).toString());
    holder.total_marks.setText("Total Mark : " + totalMakrs.get(position).toString());
}

    }

    @Override
    public int getItemCount() {
        return sujectName.size();
    }
    public class MarksViewHolder extends RecyclerView.ViewHolder{
       private TextView subject_name,max_marks,total_marks;


        public MarksViewHolder(@NonNull View itemView) {
            super(itemView);
           subject_name=itemView.findViewById(R.id.subject_name);

           max_marks=itemView.findViewById(R.id.max_marks);
           total_marks=itemView.findViewById(R.id.total_marks);
        }
    }


}
