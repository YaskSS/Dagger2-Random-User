package com.example.ass_boss.dagger_02.interfaces;

import com.example.ass_boss.dagger_02.MainActivity;
import com.example.ass_boss.dagger_02.adapter.RandomUserAdapter;
import com.example.ass_boss.dagger_02.component.RandomUserComponent;
import com.example.ass_boss.dagger_02.module.MainActivityModule;

import dagger.Component;

@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
@MainActivityScope
public interface MainActivityComponent {
    RandomUserAdapter getRandomUserAdapter();
    RandomUserApi getRandomUserApi();

    void injectMainActivity(MainActivity mainActivity);
}
