package com.example.cansis20;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    List<String> title;
    List<Integer> images;
    LayoutInflater inflater;
    TimeTableFragment timeTableFragment;
    ProfileFragment profileFragment;
    NewsFragment newsFragment;
    AttendanceFragment attendanceFragment;
    ProgressFragment progressFragment;
    CalculatorFragment calculatorFragment;
    CgpaFragment cgpaFragment;
    ProgramOutcomesFragment programOutcomesFragment;
    ChatbotFragment chatbotFragment;
    MarksFragment marksFragment;
    public Adapter(Context ctx, List<String> title, List<Integer> images){
        this.title = title;
        this.images  = images;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_dashboard,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(title.get(position));
        holder.imageview.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageview;
        TimeTableFragment timeTableFragment;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            final Intent[] intent = new Intent[1];
            textView = itemView.findViewById(R.id.textview_adpater);
            imageview  = itemView.findViewById(R.id.imageview_adapter);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   AppCompatActivity activity = (AppCompatActivity)view.getContext();
                   String typeofuser = SharedPrefManager.getInstance(activity).getTypeOfUser();
                    if(typeofuser.equals("parent")) {
                        switch (getAdapterPosition()) {
                            case 0:
                                newsFragment = new NewsFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, newsFragment).addToBackStack(null).commit();
                                ;

                                break;
                            case 1:
                                attendanceFragment = new AttendanceFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, attendanceFragment).addToBackStack(null).commit();
                                ;

                                break;
                            case 2:
                                progressFragment = new ProgressFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, progressFragment).addToBackStack(null).commit();
                                //  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                //  activity.getFragmentManager().beginTransaction();

                                break;
                            case 3:
                                profileFragment = new ProfileFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, profileFragment).addToBackStack(null).commit();

                                break;

                            case 4:
                                chatbotFragment = new ChatbotFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, chatbotFragment).addToBackStack(null).commit();
                                break;
                        }

                    }else {
                        switch (getAdapterPosition()) {
                            case 0:
                                newsFragment = new NewsFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, newsFragment).addToBackStack(null).commit();
                                ;

                                break;
                            case 1:
                                attendanceFragment = new AttendanceFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, attendanceFragment).addToBackStack(null).commit();
                                ;

                                break;
                            case 2:
                                progressFragment = new ProgressFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, progressFragment).addToBackStack(null).commit();
                                //  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                //  activity.getFragmentManager().beginTransaction();

                                break;
                            case 3:
                                timeTableFragment = new TimeTableFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, timeTableFragment).addToBackStack(null).commit();
                                break;

                            case 4:
                                cgpaFragment = new CgpaFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, cgpaFragment).addToBackStack(null).commit();

                                break;

                            case 5:
                                calculatorFragment = new CalculatorFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, calculatorFragment).addToBackStack(null).commit();

                                break;

                            case 6:
                                profileFragment = new ProfileFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, profileFragment).addToBackStack(null).commit();

                                break;


                            case 7:
                                programOutcomesFragment = new ProgramOutcomesFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, programOutcomesFragment).addToBackStack(null).commit();

                                break;
                            case 8:
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://digital.canaraengineering.in"));
                                activity.startActivity(intent);
                                break;

                            case 9:
                                chatbotFragment = new ChatbotFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, chatbotFragment).addToBackStack(null).commit();
                                break;
                            case 10:
                                marksFragment=new MarksFragment();
                                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_area, marksFragment).addToBackStack(null).commit();
                                break;

                            default:
                                // FragmentTransaction fragmentTransaction =
                                // fragmentTransaction.replace(R.id.frame_area, timeTableFragment);
                                //   fragmentTransaction.commit();
                                Toast.makeText(view.getContext(), "thisis test " + getAdapterPosition(), Toast.LENGTH_SHORT).show();

                        }
                    }

               }


           });
        }
    }



}
