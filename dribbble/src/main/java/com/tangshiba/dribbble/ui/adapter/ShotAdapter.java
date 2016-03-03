package com.tangshiba.dribbble.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agilie.dribbblesdk.domain.Shot;
import com.tangshiba.dribbble.R;

import java.util.List;

/**
 * Created by shiba on 2016/3/3.
 */
public class ShotAdapter extends RecyclerView.Adapter<ShotAdapter.ShotViewHolder> {

    private List<Shot> mShots;


    @Override
    public ShotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, null);
        return new ShotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShotViewHolder holder, int position) {
        Shot shot = mShots.get(position);

    }

    @Override
    public int getItemCount() {
        return mShots.size();
    }

    class ShotViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mViewsCount;
        TextView mCommentsCount;
        TextView mLikesCount;

        public ShotViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
            mViewsCount = (TextView) itemView.findViewById(R.id.views_count);
            mCommentsCount = (TextView) itemView.findViewById(R.id.comments_count);
            mLikesCount = (TextView) itemView.findViewById(R.id.likes_count);
        }

    }

}
