package com.example.cansis20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<String> news,date,desc;
    private LayoutInflater inflater;
    public NewsAdapter(Context context, List<String> news, List<String> date,List<String> desc) {

        this.news = news;
        this.date  = date;
        this.desc = desc;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_news,parent,false);

        return new NewsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
holder.newsDetails.setText(news.get(position));
holder.newsDate.setText("Date : "+date.get(position));
holder.newsDesc.setText(desc.get(position));

    }

    @Override
    public int getItemCount() {
        return news.size();
    }
    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private TextView newsDetails;
        private TextView newsDate;
        private TextView newsDesc;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsDetails = itemView.findViewById(R.id.news_title);
            newsDate  = itemView.findViewById(R.id.news_date);
            newsDesc = itemView.findViewById(R.id.news_desc);
        }
    }


}
