package com.example.cansis20;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressFragment extends Fragment {
private BarChart chart;

    public ProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_progress, container, false);



        BarChart barChart = (BarChart) view.findViewById(R.id.chart);



        BarDataSet bardataset = new BarDataSet(getEntries(), "Cells");



        BarData data = new BarData(getLabels(), bardataset);
        barChart.setData(data); // set the data and list of labels into chart
         bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.animateY(5000);








        return view;
    }

    private ArrayList<BarEntry> getEntries() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(80f, 0));
        entries.add(new BarEntry(20f, 1));
        entries.add(new BarEntry(50f, 2));
        entries.add(new BarEntry(20f, 3));
        entries.add(new BarEntry(40f, 4));
        entries.add(new BarEntry(90f, 5));
        entries.add(new BarEntry(100f, 6));
        return entries;
    }


    private ArrayList<String> getLabels() {
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("SEM 1");
        labels.add("SEM 2");
        labels.add("SEM 3");
        labels.add("SEM 5");
        labels.add("SEM 6");
        labels.add("SEM 7");
        labels.add("SEM 8");
        return labels;
    }


}
