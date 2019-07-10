package com.example.mvvm.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.mvvm.service.model.Posts;

public class ApiProvider implements Source {
    private String TAG = getClass().getSimpleName();
    private static final String url = "https://jsonplaceholder.typicode.com/posts/";
    public MutableLiveData<List<Posts>> mutableLiveData = new MutableLiveData<>();
    public static JsonPlaceHolderService jsonPlaceHolderService = null;

    public static JsonPlaceHolderService getService() {
        if (jsonPlaceHolderService == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            jsonPlaceHolderService = retrofit.create(JsonPlaceHolderService.class);
        }
        return jsonPlaceHolderService;
    }

    @Override
    public MutableLiveData<List<Posts>> getPostList() {
        Call<List<Posts>> postListCallBack = ApiProvider.getService().getPostList();
        postListCallBack.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                assert response.body() != null;
                Log.d(TAG, response.body().get(0).getTitle());
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
