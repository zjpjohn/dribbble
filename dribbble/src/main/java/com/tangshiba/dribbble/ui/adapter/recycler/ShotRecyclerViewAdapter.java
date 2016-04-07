package com.tangshiba.dribbble.ui.adapter.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agilie.dribbblesdk.domain.Shot;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.tangshiba.dribbble.R;

import java.util.List;

/**
 * Created by shiba on 2016/3/3.
 */
public class ShotRecyclerViewAdapter extends RecyclerView.Adapter<ShotRecyclerViewAdapter.ShotViewHolder> {

    private Context mContext;
    private List<Shot> mShots;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public ShotRecyclerViewAdapter(Context context, List<Shot> Shots) {
        mContext = context;
        mShots = Shots;
    }

    @Override
    public ShotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_shot, parent, false);
        ShotViewHolder viewHolder = new ShotViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ShotViewHolder holder, final int position) {
        Shot shot = mShots.get(position);
        if (null != mOnItemClickListener) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView, position);
                    return true;
                }
            });
        }
        Glide.with(mContext).load(shot.getImages().getNormal()).into(holder.ivShotImage);
        //Glide.with(mContext).load(shot.getUser().getAvatarUrl()).asBitmap().centerCrop().into(
        //        new BitmapImageViewTarget(holder.ivUserAvatar) {
        //            @Override
        //            protected void setResource(Bitmap resource) {
        //                RoundedBitmapDrawable circularBitmapDrawable =
        //                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
        //                circularBitmapDrawable.setCircular(true);
        //                holder.ivUserAvatar.setImageDrawable(circularBitmapDrawable);
        //            }
        //        });
        //holder.tvUsername.setText(shot.getUser().getName());
        holder.tvViewsCount.setText(String.valueOf(shot.getViewsCount()));
        holder.tvCommentsCount.setText(String.valueOf(shot.getCommentsCount()));
        holder.tvLikesCount.setText(String.valueOf(shot.getLikesCount()));
    }

    @Override
    public int getItemCount() {
        return mShots.size();
    }

    class ShotViewHolder extends RecyclerView.ViewHolder {

        ImageView ivShotImage;
        //ImageView ivUserAvatar;
        //TextView tvUsername;
        TextView tvViewsCount;
        TextView tvCommentsCount;
        TextView tvLikesCount;

        public ShotViewHolder(View itemView) {
            super(itemView);
            ivShotImage = (ImageView) itemView.findViewById(R.id.iv_shot_image);
            //ivUserAvatar = (ImageView) itemView.findViewById(R.id.iv_user_avatar);
            //tvUsername = (TextView) itemView.findViewById(R.id.tv_user_name);
            tvViewsCount = (TextView) itemView.findViewById(R.id.tv_views_count);
            tvCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_count);
            tvLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_count);
        }

    }

}
