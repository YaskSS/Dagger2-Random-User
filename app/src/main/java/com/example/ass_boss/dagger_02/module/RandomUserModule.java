package com.example.ass_boss.dagger_02.module;

import com.example.ass_boss.dagger_02.interfaces.RandomUserApi;
import com.example.ass_boss.dagger_02.interfaces.RandomUserApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module( includes = OkHttpClientModule.class)
public class RandomUserModule {

    @Provides
    public RandomUserApi randomUserApi(Retrofit retrofit) {
        return retrofit.create(RandomUserApi.class);
    }

    @RandomUserApplicationScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson, GsonConverterFactory converterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .baseUrl("https://randomuser.me/")
                .build();
    }

    @Provides
    public Gson gson() {
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    @Provides
    public GsonConverterFactory converterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}
