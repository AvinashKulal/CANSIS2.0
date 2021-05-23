package com.example.cansis20;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarksInternalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarksInternalFragment extends Fragment implements  View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button cie1,cie2,cie3,cieavg,see;
    private TextView semText;



    public MarksInternalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarksInternalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarksInternalFragment newInstance(String param1, String param2) {
        MarksInternalFragment fragment = new MarksInternalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_marks_internal, container, false);
        cie1 = view.findViewById(R.id.cie1);
        cie2 = view.findViewById(R.id.cie2);
        cie3  = view.findViewById(R.id.cie3);
        cieavg = view.findViewById(R.id.cieavg);
        see = view.findViewById(R.id.see);
        cie1.setOnClickListener(this);
        cie2.setOnClickListener(this);
        cie3.setOnClickListener(this);
        cieavg.setOnClickListener(this);
        see.setOnClickListener(this);
        semText = view.findViewById(R.id.semText);
        String text = "| SEMESTER : "+getArguments().getString("selectedSem")+" |";
        semText.setText(text);


        return view;
    }

    @Override
    public void onClick(View view) {

        AppCompatActivity activity = (AppCompatActivity)view.getContext();
        MarksDisplayFragment marksDisplayFragment = new MarksDisplayFragment();
        Bundle bundle = new Bundle();






        switch(view.getId()){

            case R.id.cie1:
                bundle.putInt("selectedCie",1);
                break;
            case R.id.cie2:
                bundle.putInt("selectedCie",2);
                break;
            case R.id.cie3:
                bundle.putInt("selectedCie",3);
                break;
            case R.id.cieavg:
                bundle.putInt("selectedCie",4);
                break;
            case R.id.see:
                bundle.putInt("selectedCie",5);
                break;

        }
        bundle.putString("selectedSem",getArguments().getString("selectedSem"));
        marksDisplayFragment.setArguments(bundle);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area,marksDisplayFragment).addToBackStack(null).commit();


    }
}