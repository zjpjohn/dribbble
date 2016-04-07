package com.tangshiba.dribbble.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangshiba.dribbble.R;
import com.tangshiba.dribbble.base.BaseFragment;

public class StoriesFragment extends BaseFragment {

    public StoriesFragment() {

    }

    public static StoriesFragment newInstance() {
        StoriesFragment fragment = new StoriesFragment();
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

    @Override
    protected int getResourceId() {
        return R.layout.fragment_stories;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
