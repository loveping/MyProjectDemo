package com.example.dan.mothertobe.retrofit;

import com.example.dan.mothertobe.Common.WebService;
import com.example.dan.mothertobe.fragment.Modle.HotReonthModle;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dandan on 2016/10/27.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HotRecommendRequest {

    private static final int DEFUAULT_TIME = 60;
    private Retrofit retrofit;
    private volatile static HotRecommendRequest INSTANCE;
    private HotRecommentServer hotRecommentServer;
    private HotRecommendRequest(){
        //
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFUAULT_TIME, TimeUnit.SECONDS);
        retrofit =new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(WebService.HOST)
                .build();
        hotRecommentServer = retrofit.create(HotRecommentServer.class);
    }

    public static HotRecommendRequest getINSTANCE(){
        if (INSTANCE == null){
            synchronized (HotRecommendRequest.class){
                if (INSTANCE == null){
                    INSTANCE = new HotRecommendRequest();
                }
            }
        }
        return INSTANCE;
    }

    public void getdata(Subscriber<HotReonthModle> subscriber, int start, int end){
        hotRecommentServer.getdata(start,end)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }
}
