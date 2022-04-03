package com.example.newsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.newsapps.models.NewsApiResponse;
import com.example.newsapps.models.NewsHeadLines;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListner {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ProgressDialog dialog;
    TabLayout tabLayout;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //////////////
        //dioalog
        dialog = new ProgressDialog(this);
        dialog.setTitle("Teching news Article...");
        dialog.show();
        RequstManeger maneger = new RequstManeger(this);
        maneger.getNewsHeadlines(listener, "GENERAL", null);
        //dioalog
        ////////////////

        ///////////////
        //searchcode
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                dialog.setTitle("Teching news Article of " + s);
                dialog.show();
                RequstManeger maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "general", s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });//searchcode

        ////////////////

        //tablayout code
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                selectedTab(pos);


            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }//tablayout code

    private final OnFetDataListener<NewsApiResponse> listener = new OnFetDataListener<NewsApiResponse>() {
        @Override
        public void onFetDAta(List<NewsHeadLines> list, String massege) {
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT);

        }
    };
    //////////////////////////

    private void showNews(List<NewsHeadLines> list) {
        recyclerView = findViewById(R.id.recycle_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customAdapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onNewsClicked(NewsHeadLines headLines) {
        startActivity(new Intent(MainActivity.this, DatailsActivity.class)
                .putExtra("data", headLines));


    }

    public void selectedTab(int pos) {
        switch (pos) {
            case 0:
                dialog.setTitle("Teching news Article of business ");
                RequstManeger maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "general", null);
                break;
            case 1:
                dialog.setTitle("Teching news Article of technology ");
                maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "technology", null);
            case 2:
                dialog.setTitle("Teching news Article of sports ");
                maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "sports", null);
            case 3:
                dialog.setTitle("Teching news Article of scince");
                maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "scince", null);
            case 4:
                dialog.setTitle("Teching news Article of health ");
                maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "health", null);
            case 5:
                dialog.setTitle("Teching news Article of entertainment ");
                maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "entertainment", null);
            case 6:
                dialog.setTitle("Teching news Article of business ");
                maneger = new RequstManeger(MainActivity.this);
                maneger.getNewsHeadlines(listener, "business", null);

        }

    }
}