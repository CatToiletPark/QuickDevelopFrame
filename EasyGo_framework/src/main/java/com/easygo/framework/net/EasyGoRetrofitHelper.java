package com.easygo.framework.net;

import retrofit2.Retrofit;

/**
 * Created by lynn on 2016/10/8.
 */

public class EasyGoRetrofitHelper {

    public static Retrofit instance(EasyGoBaseRetrofit baseRetrofit){
        return baseRetrofit.getInstanceOf();
    }

}
