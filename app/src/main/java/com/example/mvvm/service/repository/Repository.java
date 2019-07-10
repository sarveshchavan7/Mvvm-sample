package com.example.mvvm.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;


import com.example.mvvm.service.model.Posts;

public class Repository {
    private ApiProvider apiProvider = new ApiProvider();

    public MutableLiveData<List<Posts>> getPostList() {
        return apiProvider.getPostList();
    }
}

interface Source {
    MutableLiveData<List<Posts>> getPostList();
}

interface cache {
    //TODO: list all cache methods here
}