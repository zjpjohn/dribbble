package com.tangshiba.dribbble.application;

import android.app.Application;

/**
 * Created by shiba on 2016/3/3.
 */
public class DribbbleApplication extends Application {

    public static final String KEY_STATE_AUTH_TOKEN = "key_state_auth_token";

    public static final int NUMBER_OF_PAGES = 1;
    public static final int SHOTS_PER_PAGE = 5;

    public static final String DRIBBBLE_CLIENT_ID = "852df5ad94d39c83833f1fda6e809c05225ad9e422dc37a313b71c163572d3a6";
    public static final String DRIBBBLE_CLIENT_SECRET = "065fecc7c01a3df2aed9d2ef435721876493e6bdeb7ed04639452782396faeb8";
    public static final String DRIBBBLE_CLIENT_ACCESS_TOKEN = "a259d748440ffff52d0565b9a2879ea8fbeb8c7cb2a292e138659033d3319eff";
    public static final String DRIBBBLE_CLIENT_REDIRECT_URL = "http://www.tangshiba.com";

    private String authToken;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
