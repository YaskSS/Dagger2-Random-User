package com.example.ass_boss.dagger_02;

import android.app.Activity;
import android.app.Application;


import com.example.ass_boss.dagger_02.component.DaggerRandomUserComponent;
import com.example.ass_boss.dagger_02.component.RandomUserComponent;
import com.example.ass_boss.dagger_02.module.ContextModule;

import timber.log.Timber;

public class App extends Application {

    private static RandomUserComponent userComponent;

    public static App get(Activity activity){
        return (App) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

         userComponent = DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static RandomUserComponent getUserComponent() {
        return userComponent;
    }
}
