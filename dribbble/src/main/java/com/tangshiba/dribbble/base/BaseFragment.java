package com.tangshiba.dribbble.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tangkai on 2016/4/3.
 */
public abstract class BaseFragment extends Fragment {

    protected View mRootView;

    protected abstract int getResourceId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == mRootView) {
            mRootView = inflater.inflate(getResourceId(), container, false);
            initView();
            initData();
        }
        return mRootView;
    }

    protected abstract void initView();

    protected abstract void initData();

}
