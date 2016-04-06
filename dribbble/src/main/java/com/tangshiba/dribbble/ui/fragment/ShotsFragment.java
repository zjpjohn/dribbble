package com.tangshiba.dribbble.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.agilie.dribbblesdk.domain.Shot;
import com.agilie.dribbblesdk.service.retrofit.DribbbleServiceGenerator;
import com.tangshiba.dribbble.R;
import com.tangshiba.dribbble.application.DribbbleApplication;
import com.tangshiba.dribbble.base.BaseFragment;
import com.tangshiba.dribbble.ui.adapter.recycler.ShotRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ShotsFragment extends BaseFragment {

    private static final String TAG = "ShotsFragment";

    private List<Shot> mShots;
    private RecyclerView mRecyclerView;
    private ShotRecyclerViewAdapter mShotRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public ShotsFragment() {

    }

    public static ShotsFragment newInstance() {
        ShotsFragment fragment = new ShotsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    protected int getResourceId() {
        return R.layout.fragment_shots;
    }

    @Override
    public void initData() {
        DribbbleServiceGenerator
                .getShotService(DribbbleApplication.DRIBBBLE_CLIENT_ACCESS_TOKEN)
                .fetchShots(DribbbleApplication.NUMBER_OF_PAGES, DribbbleApplication.SHOTS_PER_PAGE).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Action1<List<Shot>>() {
                    @Override
                    public void call(List<Shot> shots) {
                        mShots.addAll(shots);
                        mShotRecyclerViewAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                        mRecyclerView.setVisibility(View.VISIBLE);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.d(TAG, throwable.getMessage());
                        mSwipeRefreshLayout.setRefreshing(false);
                        mRecyclerView.setVisibility(View.VISIBLE);
                        Toast.makeText(ShotsFragment.this.getContext(), "服务器错误", Toast.LENGTH_SHORT).show();
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        Toast.makeText(ShotsFragment.this.getContext(), "加载成功", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView;
        mSwipeRefreshLayout.setColorSchemeResources(R.color.primary);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "refresh", Toast.LENGTH_SHORT).show();
            }
        });
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.recycler_view_shot);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mShots = new ArrayList<>();
        mShotRecyclerViewAdapter = new ShotRecyclerViewAdapter(getContext(), mShots);
        mShotRecyclerViewAdapter.setOnItemClickListener(new ShotRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ShotsFragment.this.getContext(), "Click " + mShots.get(position).getViewsCount(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(ShotsFragment.this.getContext(), "LongClick " + mShots.get(position).getViewsCount(), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(mShotRecyclerViewAdapter);
    }

}
