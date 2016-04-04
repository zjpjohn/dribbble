package com.tangshiba.dribbble.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangshiba.dribbble.R;
import com.tangshiba.dribbble.base.BaseFragment;

public class TeamsFragment extends BaseFragment {

    public TeamsFragment() {
    }

    @SuppressWarnings("unused")
    public static TeamsFragment newInstance() {
        TeamsFragment fragment = new TeamsFragment();
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
        return R.layout.fragment_teams;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
