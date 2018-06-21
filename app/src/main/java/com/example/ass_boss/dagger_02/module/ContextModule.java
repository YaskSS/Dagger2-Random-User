package com.example.ass_boss.dagger_02.module;

import android.content.Context;

import com.example.ass_boss.dagger_02.interfaces.RandomUserApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Named("application_context")
    @RandomUserApplicationScope
    @Provides
    public Context provideContext(){
        return context.getApplicationContext();
    }
}
