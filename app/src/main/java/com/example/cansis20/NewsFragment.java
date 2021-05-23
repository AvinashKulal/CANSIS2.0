package com.example.cansis20;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class NewsFragment extends Fragment {
    private List<String> news = new ArrayList<>();
    private List<String> date = new ArrayList<>();
    private List<String> desc = new ArrayList<>();
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;
    private Button moreButton;
    private int size = 5;
    private JSONArray jsonArray;
    private ProgressDialog progressDialog;
    public NewsFragment() {
        // Required empty public constructor
    }





  private void loadNotification() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data........");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.URL_NOTIFICATION,
                new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       try {
                           jsonArray = new JSONArray(response);

                           getPostNotification(5);
                           progressDialog.dismiss();
                       } catch (JSONException e) {
                           progressDialog.dismiss();
                            e.printStackTrace();
                       }
                   }
                },
               new Response.ErrorListener() {
                   @Override
                    public void onErrorResponse(VolleyError error) {
                       progressDialog.dismiss();
                      // progressDialog.dismiss();
                       Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                  }
               });
       RequestHandler.getInstance(getContext()).addToRequestQueue(stringRequest);
   }

    private void getPostNotification(int size) {

        if(jsonArray.length()<size){
            size = jsonArray.length();
        }
        news.clear();
        desc.clear();
        date.clear();
        for (int i = 0; i < size; i++) {

            //getting product object from json array
            JSONObject note = null;
            try {
                note = jsonArray.getJSONObject(i);
                news.add(note.getString("title"));
                desc.add(note.getString("description"));
                date.add(note.getString("date"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        newsAdapter = new NewsAdapter(getContext(),news,date,desc);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView = view.findViewById(R.id.news_recylerview);
        moreButton = view.findViewById(R.id.more_news);

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                size+=5;
                Toast.makeText(getContext(),"News ADDED",Toast.LENGTH_SHORT).show();
                getPostNotification(size);

            }
        });

        loadNotification();


        return view;


    }














}
