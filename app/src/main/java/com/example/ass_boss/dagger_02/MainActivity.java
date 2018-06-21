package com.example.ass_boss.dagger_02;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ass_boss.dagger_02.adapter.RandomUserAdapter;

import com.example.ass_boss.dagger_02.component.DaggerRandomUserComponent;
import com.example.ass_boss.dagger_02.component.RandomUserComponent;
import com.example.ass_boss.dagger_02.interfaces.RandomUserApi;
import com.example.ass_boss.dagger_02.model.test.Responce;
import com.example.ass_boss.dagger_02.module.ContextModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    RandomUserApi userApi;
    Picasso picasso;
    @Inject
    RandomUserAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picasso = App.getUserComponent().getPicasso();
        userApi = App.getUserComponent().getRandomUserService();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        populateUsers();
    }

    private void populateUsers() {
        Call<Responce> randomUsersCall = getRandomUserService().getRandomUsers(10);
        randomUsersCall.enqueue(new Callback<Responce>() {
            @Override
            public void onResponse(Call<Responce> call, @NonNull Response<Responce> response) {
                Log.i("Test", "onResponse");
                if (response.isSuccessful()) {
                    Log.i("Test", "isSuccessful");
                    adapter = new RandomUserAdapter(MainActivity.this, picasso);
                    adapter.setItems(response.body().getResults());
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(getBaseContext(), "OK" , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Responce> call, Throwable t) {
                Timber.i(t.getMessage());
                Toast.makeText(getBaseContext(), "fail" , Toast.LENGTH_SHORT).show();

            }
        });
    }

    public RandomUserApi getRandomUserService() {
        return userApi;
    }

}
