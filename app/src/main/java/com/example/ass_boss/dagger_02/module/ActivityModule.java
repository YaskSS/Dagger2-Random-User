package com.example.ass_boss.dagger_02.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Named("activity_context")
    @Provides
    public Context provideContext(){
        return context;
    }
}
