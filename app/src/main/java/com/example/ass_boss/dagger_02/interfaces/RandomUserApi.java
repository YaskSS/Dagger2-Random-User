package com.example.ass_boss.dagger_02.interfaces;


import com.example.ass_boss.dagger_02.model.test.Responce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUserApi {

    @GET("api")
    Call<Responce> getRandomUsers(@Query("results") int size);
}

