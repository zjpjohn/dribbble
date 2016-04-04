package com.tangshiba.dribbble.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import com.tangshiba.dribbble.R;
import com.tangshiba.dribbble.base.BaseFragment;


public class ShopFragment extends BaseFragment {

    public ShopFragment() {
        // Required empty public constructor
    }

    public static ShopFragment newInstance() {
        ShopFragment fragment = new ShopFragment();
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
        return R.layout.fragment_shops;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
