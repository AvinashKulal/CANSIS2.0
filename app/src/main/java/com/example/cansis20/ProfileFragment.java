package com.example.cansis20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    TextView student_name,student_phone,student_email,student_branch,student_address,student_year,student_parentname,student_parentno;
ImageView student_image;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);

        student_name = view.findViewById(R.id.student_name);
        student_phone=view.findViewById(R.id.phone);
        student_email=view.findViewById(R.id.email);
        student_branch = view.findViewById(R.id.s_branch);
        student_address = view.findViewById(R.id.s_address);
        student_year = view.findViewById(R.id.s_year);
        student_parentname = view.findViewById(R.id.s_mother);
        student_parentno = view.findViewById(R.id.s_mno);
        student_image=view.findViewById(R.id.s_image);




        List<String> student_details = new ArrayList<>();
       student_details = SharedPrefManager.getInstance(this.getContext()).getStudentDetails();


       student_phone.setText("Phone : "+student_details.get(0));

        student_branch.setText("Branch : "+student_details.get(1));

        student_name.setText(student_details.get(2).toUpperCase());

        student_address.setText("Address : "+student_details.get(3));

        student_email.setText("Email : "+student_details.get(4));

        student_parentname.setText("Parent Name : "+student_details.get(5));

        student_parentno.setText("Parent Number : "+student_details.get(6));

        student_year.setText("Year : "+student_details.get(7));


        //profile image
        Picasso.get().load( Constants.IMG_URL+student_details.get(8)).into(student_image);






        return view;
    }
}
