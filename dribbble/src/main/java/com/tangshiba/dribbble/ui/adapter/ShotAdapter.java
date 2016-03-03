package com.tangshiba.dribbble.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.agilie.dribbblesdk.domain.Shot;

import java.util.List;

/**
 * Created by shiba on 2016/3/3.
 */
public class ShotAdapter extends RecyclerView.Adapter<ShotAdapter.ShotViewHolder> {

    private List<Shot> mShots;


    @Override
    public ShotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ShotViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mShots.size();
    }

    class ShotViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;


        public ShotViewHolder(View itemView) {
            super(itemView);
        }
    }

}
