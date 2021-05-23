package com.example.cansis20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarksDisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarksDisplayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView semText;

    private List<String> subjectName = new ArrayList<>();
    private List<Integer> maxMarks=new ArrayList<>();
    private List<Integer> totalMarks=new ArrayList<>();
    private List<String> grade = new ArrayList<>();
    private RecyclerView recyclerView;
    private MarksAdapter marksAdapter;
    private ProgressDialog progressDialog;
    public MarksDisplayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarksDisplayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarksDisplayFragment newInstance(String param1, String param2) {
        MarksDisplayFragment fragment = new MarksDisplayFragment();
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




    private void loadMarks() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();


        final String sem = getArguments().getString("selectedSem");
        final String cie = String.valueOf(getArguments().getInt("selectedCie"));

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, Constants.URL_MARKS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);
                            if(array.length()<1){
                                progressDialog.dismiss();
                                Toast.makeText(getContext(),"Data Unavailable..",Toast.LENGTH_SHORT).show();
                                getFragmentManager().popBackStack();
                            }

                            //traversing through all the object

                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject mark = array.getJSONObject(i);

                                //adding the notification to notification list
                                subjectName.add(mark.getString("subject_name"));
                                if(cie.equals("5")){
                                    grade.add(String.valueOf(mark.getInt("max_marks")));
                                }else {
                                    maxMarks.add(mark.getInt("max_marks"));
                                }
                                totalMarks.add(mark.getInt("total_marks"));


                            }
                            progressDialog.dismiss();
                            //creating adapter object and setting it to recyclerview
                            if(cie.equals("5"))
                            {
                                marksAdapter = new MarksAdapter(getContext(), subjectName, grade, totalMarks,1);
                            }else{
                                marksAdapter = new MarksAdapter(getContext(), subjectName, maxMarks, totalMarks);
                            }

                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(gridLayoutManager);
                            recyclerView.setAdapter(marksAdapter);


                        } catch (Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //progressDialog.dismiss();
                Toast.makeText(getContext(), error.getMessage() + "Volley error", Toast.LENGTH_SHORT).show();

            }
        }


        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Toast.makeText(getApplicationContext(),"out",Toast.LENGTH_SHORT).show();

                Map<String, String> params = new HashMap<>();
                params.put("sem", sem);
                params.put("cie", cie);
                params.put("stud_id",SharedPrefManager.getInstance(getContext()).getStudentId());
                return params;

            }
        };
        RequestHandler.getInstance(getContext()).addToRequestQueue(stringRequest);


    }















    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_marks_display, container, false);
        semText = view.findViewById(R.id.semCieText);
        int semNumber = getArguments().getInt("selectedCie");
        String text = "| CIE-"+String.valueOf(semNumber)+" |";
        if(semNumber == 4) {
        text = "| CIE-AVERAGE |";
        }
        if(semNumber == 5){
            text = "| SEE | ";
        }

        semText.setText(text);
        recyclerView = view.findViewById(R.id.marks_recyclerview);
        loadMarks();
        return view;
    }
}