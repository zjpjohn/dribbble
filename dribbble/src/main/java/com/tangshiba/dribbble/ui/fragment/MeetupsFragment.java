package com.tangshiba.dribbble.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangshiba.dribbble.R;
import com.tangshiba.dribbble.base.BaseFragment;


public class MeetupsFragment extends BaseFragment {

    public MeetupsFragment() {

    }

    public static MeetupsFragment newInstance() {
        MeetupsFragment fragment = new MeetupsFragment();
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
        return R.layout.fragment_meetups;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
