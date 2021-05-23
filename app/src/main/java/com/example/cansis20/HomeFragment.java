package com.example.cansis20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ViewFlipper v_flipper;
    RecyclerView recyclerView;

    List<String> title;
    List<Integer> images;
    Adapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home, container, false);

        //int image[]={R.drawable.canarimage,R.drawable.canarimage,R.drawable.canarimage};
       // v_flipper=v.findViewById(R.id.v_flipper);
        recyclerView = v.findViewById(R.id.dashboard);

        title = new ArrayList<>();
        images = new ArrayList<>();

        String typeofuser = SharedPrefManager.getInstance(this.getContext()).getTypeOfUser();

        if(typeofuser.equals("parent")) {
            title.add("CIRCULARS");
            title.add("ATTENDANCE");
            title.add("PROGRESS REPORT");
            title.add("PROFILE");
            title.add("CHATBOT");

            images.add(R.drawable.news);
            images.add(R.drawable.attendance2);
            images.add(R.drawable.piechart);
            images.add(R.drawable.userprofile);
            images.add(R.drawable.chatbot);

        }else {


            title.add("CIRCULARS");
            title.add("ATTENDANCE");
            title.add("PROGRESS REPORT");
            title.add("TIME TABLE");
            title.add("CGPA CALCULATOR");

            title.add("SGPA CALCULATOR");
            title.add("PROFILE");
            title.add("ABOUT DEPT");
            title.add("E-LEARNING");
            title.add("CHATBOT");
            title.add("MARKS");

            images.add(R.drawable.news);
            images.add(R.drawable.attendance2);
            images.add(R.drawable.piechart);
            images.add(R.drawable.timetable);
            images.add(R.drawable.calculator1);
            images.add(R.drawable.calculator2);
            images.add(R.drawable.userprofile);
            images.add(R.drawable.university);
            images.add(R.drawable.elearning);
            images.add(R.drawable.chatbot);
            images.add(R.drawable.marks);
        }



        /*

        for(int img:image)
        {
            flipperImage(img);
        }
        //viewFlipper
*/

        adapter = new Adapter(getContext(),title,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);



        return v;
    }

    //viewFlipper
  /*  public void flipperImage(int image){
        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(image);


        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(getContext(),android.R.anim.slide_out_right);

    }*/

}

