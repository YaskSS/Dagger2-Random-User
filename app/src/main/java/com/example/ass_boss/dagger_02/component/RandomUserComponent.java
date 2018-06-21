package com.example.ass_boss.dagger_02.component;

import com.example.ass_boss.dagger_02.interfaces.RandomUserApi;
import com.example.ass_boss.dagger_02.interfaces.RandomUserApplicationScope;
import com.example.ass_boss.dagger_02.module.PicassoModule;
import com.example.ass_boss.dagger_02.module.RandomUserModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@RandomUserApplicationScope
@Component(modules = {RandomUserModule.class, PicassoModule.class})
public interface RandomUserComponent {

    RandomUserApi getRandomUserService();
    Picasso getPicasso();
}
