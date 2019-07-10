package com.example.mvvm.viewmodel;


import android.app.Application;

import java.util.List;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.mvvm.service.model.Posts;
import com.example.mvvm.service.repository.Repository;

public class ListViewModel extends AndroidViewModel {
    private String TAG = getClass().getSimpleName();
    public MutableLiveData<List<Posts>> postList;
    Repository repository;
    public ListViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public MutableLiveData<List<Posts>> getPostList(){
        postList = repository.getPostList();
        return  postList;
    }
}
