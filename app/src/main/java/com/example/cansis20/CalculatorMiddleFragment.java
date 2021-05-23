package com.example.cansis20;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
 */
public class CalculatorMiddleFragment extends Fragment {
    private RecyclerView recyclerView;
    private Button calculateButton;
    private List<CalculatorGetterSetter> subjectCreditList;
    private ProgressDialog progressDialog;
    public CalculatorMiddleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator_middle, container, false);
        recyclerView = view.findViewById(R.id.calculator_recyler_view);
        calculateButton = view.findViewById(R.id.calculateBtn);
        subjectCreditList = new ArrayList<CalculatorGetterSetter>();
        progressDialog = new ProgressDialog(getContext());


        final  String sem =getArguments().getString("sem");
        final String branch = getArguments().getString("branch");
        final String year = getArguments().getString("year");

        progressDialog.setMessage("Loding Data..");


       progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, Constants.URL_SUBJECT_CREDIT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONArray array = new JSONArray(response);
                            if(array.length() ==0)
                            {
                                Toast.makeText(getContext(),"Data Unavailable",Toast.LENGTH_SHORT).show();
                                getFragmentManager().popBackStack();
                            }else {
                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject jsonObject = array.getJSONObject(i);
                                    subjectCreditList.add(new CalculatorGetterSetter(

                                            jsonObject.getString("subject"),
                                            jsonObject.getInt("creditScore")
                                    ));


                                }

                                calculateButton.setVisibility(View.VISIBLE);
                                CalculatorAdapter calculatorAdapter = new CalculatorAdapter(subjectCreditList);
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                                recyclerView.setAdapter(calculatorAdapter);

                            }





                        }
                        catch (Exception e) {
                            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Toast.makeText(getContext(),error.getMessage()+"Volley error",Toast.LENGTH_SHORT).show();

            }
        }


        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("sem",sem );
                params.put("branch", branch);
                params.put("year", year);
                return params;

            }
        };
        RequestHandler.getInstance(getContext()).addToRequestQueue(stringRequest);






        //networking









        /*
        subjectCreditList.add(new CalculatorGetterSetter("FRIST", 4));
        subjectCreditList.add(new CalculatorGetterSetter("SECOND", 4));
        subjectCreditList.add(new CalculatorGetterSetter("THIRD", 4));
        subjectCreditList.add(new CalculatorGetterSetter("FOURTH", 3));
        subjectCreditList.add(new CalculatorGetterSetter("FIFTH", 3));
        subjectCreditList.add(new CalculatorGetterSetter("SIXTH", 3));
        subjectCreditList.add(new CalculatorGetterSetter("SEVENTH", 2));
        subjectCreditList.add(new CalculatorGetterSetter("EITH", 2));

    */




        calculateButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int enteredMarks,gradePoint,creditpoint;
                float numerator = 0;
                float denominator = 0;


                for (int i = 0; i < recyclerView.getChildCount(); i++) {

                    View myView = recyclerView.getChildAt(i);
                    EditText nameEditText = (EditText) myView.findViewById(R.id.markEdt);
                    if( TextUtils.isEmpty(nameEditText.getText()) || Integer.parseInt(nameEditText.getText().toString())>100 ){
                        nameEditText.setError( "Invalid" );

                        return;

                    }else{
                         enteredMarks = Integer.parseInt(nameEditText.getText().toString());
                         gradePoint = getGradePoint(enteredMarks);
                         creditpoint = subjectCreditList.get(i).getCreditScore();
                         numerator+=(gradePoint*creditpoint);
                         denominator+=creditpoint;


                    }
                }
                //PromptDialgue



                LayoutInflater li = LayoutInflater.from(getContext());
                View promptsView = li.inflate(R.layout.sgpa_prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                TextView score = (TextView) promptsView.findViewById(R.id.sgpaScore);
                score.setText( String. format("%.2f", (numerator/denominator)) );
                alertDialogBuilder.setCancelable(false)
                        .setNegativeButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();


                alertDialog.show();

                //PromptDialgoue




            }




        });
        return view;
    }

    private int getGradePoint(int mark) {

        if(mark>=90)return 10;
        if(mark>=80)return 9;
        if(mark>=70)return 8;
        if(mark>=60)return 7;
        if(mark>=50)return 6;
        if(mark>=45)return 5;
        if(mark>=40)return 4;

        return 0;


    }
}