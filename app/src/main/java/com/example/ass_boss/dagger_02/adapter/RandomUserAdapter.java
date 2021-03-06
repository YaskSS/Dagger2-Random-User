package com.example.ass_boss.dagger_02.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ass_boss.dagger_02.MainActivity;
import com.example.ass_boss.dagger_02.R;
import com.example.ass_boss.dagger_02.model.test.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserAdapter.RandomUserViewHolder> {

    private final Picasso picasso;
    private final MainActivity mainActivity;
    private List<Result> resultList = new ArrayList<>();


    public RandomUserAdapter(MainActivity mainActivity, Picasso picasso) {
        this.mainActivity = mainActivity;
        this.picasso = picasso;
    }

    @Override
    public RandomUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_random_user,
                parent, false);
        return new RandomUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RandomUserViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.textView.setText(String.format("%s %s", result.getName().getFirst(),
                result.getName().getLast()));
        picasso.load(result.getPicture().getLarge())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<Result> results) {
        resultList = results;
        notifyDataSetChanged();
        Log.i("Test", "setItems");
    }

    public class RandomUserViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public RandomUserViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
