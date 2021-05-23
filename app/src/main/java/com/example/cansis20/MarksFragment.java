package com.example.cansis20;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarksFragment extends Fragment implements View.OnClickListener{
    private List<String> subjectName = new ArrayList<>();
    private List<Integer> examinationType=new ArrayList<>();
    private List<Integer> maxMarks=new ArrayList<>();
    private List<Integer> totalMarks=new ArrayList<>();
    private RecyclerView recyclerView;
    private MarksAdapter marksAdapter;
    private Button sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MarksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarksFragment newInstance(String param1, String param2) {
        MarksFragment fragment = new MarksFragment();
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
        View view =  inflater.inflate(R.layout.fragment_marks, container, false);

        sem1  = view.findViewById(R.id.sem1);
        sem2  = view.findViewById(R.id.sem2);
        sem3  = view.findViewById(R.id.sem3);
        sem4  = view.findViewById(R.id.sem4);
        sem5  = view.findViewById(R.id.sem5);
        sem6  = view.findViewById(R.id.sem6);
        sem7  = view.findViewById(R.id.sem7);
        sem8  = view.findViewById(R.id.sem8);
        sem1.setOnClickListener(this);
        sem2.setOnClickListener(this);
        sem3.setOnClickListener(this);
        sem4.setOnClickListener(this);
        sem5.setOnClickListener(this);
        sem6.setOnClickListener(this);
        sem7.setOnClickListener(this);
        sem8.setOnClickListener(this);
       // recyclerView = view.findViewById(R.id.marks_recylerview);
       // loadMarks();


        return view;
    }

    @Override
    public void onClick(View view) {
        AppCompatActivity activity = (AppCompatActivity)view.getContext();
        MarksInternalFragment marksInternalFragment = new MarksInternalFragment();
        Bundle bundle = new Bundle();


        switch(view.getId()){

            case R.id.sem1:
                bundle.putString("selectedSem","1");
                Toast.makeText(getContext(),"SEM 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sem2:
                bundle.putString("selectedSem","2");
                Toast.makeText(getContext(),"SEM 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sem3:
                bundle.putString("selectedSem","3");
                Toast.makeText(getContext(),"SEM 3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sem4:
                bundle.putString("selectedSem","4");
                Toast.makeText(getContext(),"SEM 4",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sem5:
                bundle.putString("selectedSem","5");
                Toast.makeText(getContext(),"SEM 5",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sem6:
                bundle.putString("selectedSem","6");
                Toast.makeText(getContext(),"SEM 6",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sem7:
                bundle.putString("selectedSem","7");
                Toast.makeText(getContext(),"SEM 7",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sem8:
                bundle.putString("selectedSem","8");

                Toast.makeText(getContext(),"SEM 8",Toast.LENGTH_SHORT).show();
                break;

        }
        marksInternalFragment.setArguments(bundle);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area,marksInternalFragment).addToBackStack(null).commit();

    }
}