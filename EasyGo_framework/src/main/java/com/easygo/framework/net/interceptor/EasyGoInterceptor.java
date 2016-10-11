package com.easygo.framework.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lynn on 2016/10/11.
 */

public class EasyGoInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //do something you want to
        request = request.newBuilder().build();
        return chain.proceed(request);
    }
}
