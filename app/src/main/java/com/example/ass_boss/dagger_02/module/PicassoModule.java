package com.example.ass_boss.dagger_02.module;

import android.content.Context;

import com.example.ass_boss.dagger_02.interfaces.RandomUserApplicationScope;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = OkHttpClientModule.class)
public class PicassoModule {

    @RandomUserApplicationScope
    @Provides
    public Picasso providePicasso(@Named("application_context") Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    public OkHttp3Downloader provideOkHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}
