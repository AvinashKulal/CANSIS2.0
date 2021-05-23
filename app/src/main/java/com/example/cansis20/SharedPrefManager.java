package com.example.cansis20;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class SharedPrefManager {


    private static SharedPrefManager mInstance;

    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USER_PHONE = "userphone";
    private static final String KEY_USER_BRANCH = "userbranch";
    private static final String KEY_TYPE_USER ="parent";
    private static final String KEY_USER_NAME ="shambu";
    private static final String KEY_USER_ADDRESS = "manglore";
    private static final String KEY_USER_EMAIL = "dhanush@gmail.com";
    private static final String KEY_USER_MOTHERS_NAME ="dddd";
    private static final String KEY_USER_MOTHER_NO = "99033838383";
    private static final String KEY_USER_YEAR = "3";
    private static final String KEY_USER_IMAGE = "untitled.jpg";

    //notification
    private static final String KEY_NOTE_TITLE="title";
    private static final String KEY_NOTE_DESC="desc";
    private static final String KEY_NOTE_DATE="date";



    private static final String KEY_USER_ID = "" + "";

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


public boolean userNotification(String title,String description,String date){



    SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();


    editor.putString(KEY_NOTE_TITLE,title);
    editor.putString(KEY_NOTE_DESC,description);
    editor.putString(KEY_NOTE_DATE,date);

    editor.apply();

    Log.i("mynote",title);


    return true;
}



public boolean userLogin(String name,String phone,String address,String email,String mothers_name,String mothers_no,String branch,String year,String image,String student_id) {
    Log.i("tag",phone);
    SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();


    editor.putString(KEY_USER_PHONE,phone);
    editor.putString(KEY_USER_BRANCH,branch);
    editor.putString(KEY_TYPE_USER,"student");
    editor.putString(KEY_USER_NAME,name);
    editor.putString(KEY_USER_ADDRESS,address);
    editor.putString(KEY_USER_EMAIL,email);
    editor.putString(KEY_USER_MOTHERS_NAME,mothers_name);
    editor.putString(KEY_USER_MOTHER_NO,mothers_no);
    editor.putString(KEY_USER_YEAR,year);
    editor.putString(KEY_USER_IMAGE,image);
    editor.putString(KEY_USER_ID,student_id);


    editor.apply();


return true;
    }





    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        if(sharedPreferences.getString(KEY_USER_PHONE,null)!=null){
            return true;
        }
        return false;

    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.clear();
    editor.apply();
    return true;
    }




    public String getBranch(){


        SharedPreferences preferences = mCtx.getSharedPreferences("mysharedpref12", Context.MODE_PRIVATE);
        String userBrnach = preferences.getString(KEY_USER_BRANCH,null);
        return userBrnach;
    }

    public String getStudentId(){


        SharedPreferences preferences = mCtx.getSharedPreferences("mysharedpref12", Context.MODE_PRIVATE);
        return preferences.getString(KEY_USER_ID,null);

    }


    public String getTypeOfUser(){


        SharedPreferences preferences = mCtx.getSharedPreferences("mysharedpref12", Context.MODE_PRIVATE);
        String typeofuser = preferences.getString(KEY_TYPE_USER,null);
        return typeofuser;
    }

   public List<String> getStudentDetails(){

        List<String> details = new ArrayList<>();

        SharedPreferences preferences = mCtx.getSharedPreferences("mysharedpref12", Context.MODE_PRIVATE);



        details.add(preferences.getString(KEY_USER_PHONE,null));
        details.add(preferences.getString(KEY_USER_BRANCH,null));
        details.add(preferences.getString(KEY_USER_NAME,null));
        details.add(preferences.getString(KEY_USER_ADDRESS,null));
        details.add(preferences.getString(KEY_USER_EMAIL,null));
        details.add(preferences.getString(KEY_USER_MOTHERS_NAME,null));
        details.add(preferences.getString(KEY_USER_MOTHER_NO,null));
        details.add(preferences.getString(KEY_USER_YEAR,null));
        details.add(preferences.getString(KEY_USER_IMAGE,null));



       Log.i("mynumber",preferences.getString(KEY_USER_MOTHER_NO,null));



        return details;



    }


}
