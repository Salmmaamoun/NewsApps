package com.example.newsapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapps.models.NewsHeadLines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    List<NewsHeadLines>headLines;
    private SelectListner listner;

    public CustomAdapter(Context context, List<NewsHeadLines> headLines, SelectListner listner) {
        this.context = context;
        this.headLines = headLines;
        this.listner = listner;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_item,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_tittle.setText(headLines.get(position).getTitle());
        holder.txt_source.setText(headLines.get(position).getSource().getName());
        if(headLines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headLines.get(position).getUrlToImage()).into(holder.img_headline);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onNewsClicked(headLines.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return headLines.size();
    }
}
