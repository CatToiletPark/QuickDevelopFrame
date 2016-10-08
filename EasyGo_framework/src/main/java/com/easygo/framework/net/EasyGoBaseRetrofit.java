package com.easygo.framework.net;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * description :
 *
 * @author by lyh on 2016/10/6 17:17.
 */

public abstract class EasyGoBaseRetrofit {

    private  Retrofit.Builder builder = new Retrofit.Builder();

    public Retrofit getInstanceOf() {
        return builder.baseUrl(getHostAddress())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient())
                .build();
    }

    protected abstract String getHostAddress();

}
