package com.tangshiba.dribbble.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tangshiba.dribbble.R;
import com.tangshiba.dribbble.base.BaseFragment;

public class TeamsFragment extends BaseFragment {


    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TeamsFragment() {
    }

    @SuppressWarnings("unused")
    public static TeamsFragment newInstance(int columnCount) {
        TeamsFragment fragment = new TeamsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    protected int getResourceId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

}
