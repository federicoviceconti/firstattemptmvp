package com.vetrya.firstattemptmvp.http;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Federico on 6/28/2017.
 * If you find any bugs, contact me!
 */

@Module
public class UserDisplayHttpModule {
    private static final String BASE_URL = "https://reqres.in";

    @Singleton
    @Provides
    OkHttpClient providesClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //.client(providesClient()) --> cause unexpected exception
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    UserDisplayHttpApi providesApi(){
        return providesRetrofit().create(UserDisplayHttpApi.class);
    }
}
