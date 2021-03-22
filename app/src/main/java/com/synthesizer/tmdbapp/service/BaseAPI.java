package com.synthesizer.tmdbapp.service;

import com.synthesizer.tmdbapp.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseAPI {

    private static final String BASEURL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit;

    private BaseAPI(){
         retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(builder())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient builder(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        okHttpClient.connectTimeout(20, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(20, TimeUnit.SECONDS);
        okHttpClient.readTimeout(30, TimeUnit.SECONDS);

        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key", BuildConfig.API_KEY)
                        .build();

                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });

        return okHttpClient.build();
    }

    public static Retrofit getAPI(){
        if(retrofit==null) new BaseAPI();
        return retrofit;
    }
}
