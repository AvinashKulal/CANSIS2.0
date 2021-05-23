package com.example.cansis20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceFragment extends Fragment {
    private List<String> subject;
    private List<List<Integer>> attendance;
    private RecyclerView recyclerView;
    private AttendanceAdapter attendanceAdapter;
    public AttendanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_attendance, container, false);
        subject = new ArrayList<>();
        attendance = new ArrayList<>();
        recyclerView = view.findViewById(R.id.attendance_recyclerview);


      //creating adapter object and setting it to recyclerview
        attendanceAdapter = new AttendanceAdapter(getContext(),subject,attendance);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(attendanceAdapter);
        return view;
    }
}
