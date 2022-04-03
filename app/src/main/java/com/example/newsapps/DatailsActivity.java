package com.example.newsapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapps.models.NewsHeadLines;
import com.squareup.picasso.Picasso;

public class DatailsActivity extends AppCompatActivity {
    NewsHeadLines headLines;
TextView tv_tittle,tv_content,tv_source;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datails);
        headLines= (NewsHeadLines) getIntent().getSerializableExtra("data");
        tv_tittle=findViewById(R.id.tv_title);
        tv_source=findViewById(R.id.tv_source);
        img=findViewById(R.id.img_details);
        tv_tittle.setText(headLines.getTitle());
        tv_source.setText( headLines.getSource().getName());
        Picasso.get().load(headLines.getUrlToImage()).into(img);



    }
}