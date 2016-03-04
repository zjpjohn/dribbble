package com.tangshiba.dribbble.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agilie.dribbblesdk.domain.Shot;
import com.loopj.android.image.SmartImageView;
import com.tangshiba.dribbble.R;

import java.util.List;

/**
 * Created by shiba on 2016/3/3.
 */
public class ShotAdapter extends RecyclerView.Adapter<ShotAdapter.ShotViewHolder> {

    private Context mContext;
    private List<Shot> mShots;


    public ShotAdapter(Context context, List<Shot> Shots) {
        mContext = context;
        mShots = Shots;
    }


    @Override
    public ShotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);
        ShotViewHolder viewHolder = new ShotViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShotViewHolder holder, int position) {
        Shot shot = mShots.get(position);
        holder.mImageView.setImageUrl(shot.getImages().getHidpi());
        holder.mViewsCount.setText(String.valueOf(shot.getViewsCount()));
        holder.mCommentsCount.setText(String.valueOf(shot.getCommentsCount()));
        holder.mLikesCount.setText(String.valueOf(shot.getLikesCount()));
    }

    @Override
    public int getItemCount() {
        return mShots.size();
    }

    class ShotViewHolder extends RecyclerView.ViewHolder {

        SmartImageView mImageView;
        TextView mViewsCount;
        TextView mCommentsCount;
        TextView mLikesCount;

        public ShotViewHolder(View itemView) {
            super(itemView);
            mImageView = (SmartImageView) itemView.findViewById(R.id.image_view);
            mViewsCount = (TextView) itemView.findViewById(R.id.views_count);
            mCommentsCount = (TextView) itemView.findViewById(R.id.comments_count);
            mLikesCount = (TextView) itemView.findViewById(R.id.likes_count);
        }

    }

}
