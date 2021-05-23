package com.example.cansis20;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    LinearLayout lyoutList;
    Button buttonadd,findSgpa,clearAll;
    ArrayList<CalculatorGetterSetter> scoreList;
    List<String> typeOfSubjects,creditPoints;
    private Spinner semspinner,branchSpinner;
    private EditText yearEditeText;
    private Button nextBtn;
    CalculatorMiddleFragment calculatorMiddleFragment;
    private String selectedSem,selectedBranch;
    private int selectedYear ;
    // TextView  instruction;
    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_calculator, container, false);

        semspinner = view.findViewById(R.id.semSpn);
        branchSpinner = view.findViewById(R.id.branchSpn);
        yearEditeText = view.findViewById(R.id.yearEditTxt);
        nextBtn = view.findViewById(R.id.nextBtn);



        final String[] sem = { "1", "2", "3", "4", "5","6","7","8"};
        final String[] branch = {"CSE","ECE","EEE","ISE","ME"};

        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,sem);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semspinner.setAdapter(aa);


        ArrayAdapter bb = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,branch);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchSpinner.setAdapter(bb);



        semspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedSem = sem[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        branchSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedBranch = branch[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(yearEditeText.getText()) || yearEditeText.getText().toString().length() <4 ){
                    yearEditeText.setError( "Invalid" );
                    return;

                }
                selectedYear=Integer.parseInt(yearEditeText.getText().toString());
                calculatorMiddleFragment  = new CalculatorMiddleFragment();
                Bundle bundle = new Bundle();
                bundle.putString("sem",selectedSem);
                bundle.putString("branch",selectedBranch);
                bundle.putString("year",String.valueOf(selectedYear) );
                calculatorMiddleFragment.setArguments(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_area, calculatorMiddleFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }

}
