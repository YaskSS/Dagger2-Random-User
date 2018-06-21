package com.example.ass_boss.dagger_02.module;

import com.example.ass_boss.dagger_02.MainActivity;
import com.example.ass_boss.dagger_02.adapter.RandomUserAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    public RandomUserAdapter provideRandomUserAdapter(Picasso picasso){
        return new RandomUserAdapter(mainActivity, picasso);
    }
}
