package com.example.newsapps;

import com.example.newsapps.models.NewsApiResponse;
import com.example.newsapps.models.NewsHeadLines;

import java.util.ArrayList;
import java.util.List;

public interface OnFetDataListener<NewsApiResponse> {
 void onFetDAta(List<NewsHeadLines> list, String massege);
 void onError(String message);

}

