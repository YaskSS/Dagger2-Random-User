package com.example.ass_boss.dagger_02.module;

import android.content.Context;

import com.example.ass_boss.dagger_02.interfaces.RandomUserApplicationScope;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class OkHttpClientModule {

    @Provides
    public OkHttpClient provideOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    public Cache provideCache(File file) {
        return new Cache(file, 10 * 1000 * 1000);//10 MB
    }

    @RandomUserApplicationScope
    @Provides
    public File provideFile(@Named("application_context") Context context) {
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdir();
        return file;
    }

    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
