package com.example.newsapps;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
TextView txt_tittle,txt_source;
ImageView img_headline;
CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_tittle=itemView.findViewById(R.id.tv_tittle);
        txt_source=itemView.findViewById(R.id.tv_source);
        img_headline=itemView.findViewById(R.id.img_headline);
        cardView=itemView.findViewById(R.id.main_container);
    }
}
