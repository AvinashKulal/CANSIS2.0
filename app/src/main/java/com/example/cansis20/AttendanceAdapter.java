package com.example.cansis20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder> {
    private List<String> subjects;
    private List<List<Integer>> attendance;
    private LayoutInflater inflater;

    public AttendanceAdapter(Context context, List<String> subject, List<List<Integer>> attendance) {
        this.inflater = LayoutInflater.from(context);
        this.subjects = subject;
        this.attendance = attendance;
    }

    @NonNull
    @Override
    public AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_attendace,parent,false);

        return new AttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder holder, int position) {
    holder.subjectName.setText(subjects.get(position));
    holder.internal1.setText("IA1 : "+attendance.get(position).get(0).toString());
    holder.internal2.setText("IA2 : "+attendance.get(position).get(1).toString());
    holder.internal3.setText("IA3 : "+attendance.get(position).get(2).toString());
    float avg = (attendance.get(position).get(0)+attendance.get(position).get(1)+attendance.get(position).get(2))/3 ;
    holder.average.setText("AVG : "+Float.toString(avg));
    float percentage_marks = ((avg*100)/30);

    holder.percentage.setText("PERCN : "+new DecimalFormat("##.##").format(percentage_marks)+"%");


    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class AttendanceViewHolder extends RecyclerView.ViewHolder {
        private TextView subjectName,internal1,internal2,internal3,average,percentage;
        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subject_name);
            internal1 = itemView.findViewById(R.id.internal1);
            internal2 = itemView.findViewById(R.id.internal2);
            internal3 = itemView.findViewById(R.id.internal3);
            average = itemView.findViewById(R.id.average_attendance);
            percentage = itemView.findViewById(R.id.percentage_attendance);

        }
    }
}
