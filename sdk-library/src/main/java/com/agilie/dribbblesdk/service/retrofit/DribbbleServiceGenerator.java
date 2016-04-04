package com.agilie.dribbblesdk.service.retrofit;

import com.agilie.dribbblesdk.service.retrofit.services.DribbbleBucketsService;
import com.agilie.dribbblesdk.service.retrofit.services.DribbbleProjectsService;
import com.agilie.dribbblesdk.service.retrofit.services.DribbbleShotsService;
import com.agilie.dribbblesdk.service.retrofit.services.DribbbleTeamsService;
import com.agilie.dribbblesdk.service.retrofit.services.DribbbleUserService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DribbbleServiceGenerator {

    private static String DRIBBBLE_API_BASE_URL = "https://api.dribbble.com/v1/";

    private static Retrofit mRetrofit;

    private static Retrofit getRestAdapter(final String authToken) {
        if (null == mRetrofit) {
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Request authRequest = request.newBuilder().addHeader("Authorization", "Bearer " + authToken).build();
                    return chain.proceed(authRequest);
                }
            }).build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(DRIBBBLE_API_BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static DribbbleBucketsService getBucketService(final String authToken) {
        return getRestAdapter(authToken).create(DribbbleBucketsService.class);
    }

    public static DribbbleProjectsService getProjectService(final String authToken) {
        return getRestAdapter(authToken).create(DribbbleProjectsService.class);
    }

    public static DribbbleShotsService getShotService(final String authToken) {
        return getRestAdapter(authToken).create(DribbbleShotsService.class);
    }

    public static DribbbleTeamsService getTeamService(final String authToken) {
        return getRestAdapter(authToken).create(DribbbleTeamsService.class);
    }

    public static DribbbleUserService getUserService(final String authToken) {
        return getRestAdapter(authToken).create(DribbbleUserService.class);
    }

}
