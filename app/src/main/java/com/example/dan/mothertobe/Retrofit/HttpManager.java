package com.example.dan.mothertobe.retrofit;



import com.example.dan.mothertobe.Common.WebService;
import com.example.dan.mothertobe.fragment.Modle.HotMonthModle;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dandan on 2016/10/26.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HttpManager {
    private static final int DEFAULT_TIMEOUT = 20;
    private volatile static HttpManager INSTANCE;
    private TestServer testServer;
    private Retrofit retrofit;
    private HttpManager(){
        //手动创建一个okhttpclient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //第一个参数表示时间，第二个参数表示是小时，还是分钟，还是秒
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(WebService.MAIN)
                .build();
        testServer = retrofit.create(TestServer.class);
    }
    //在访问HttpMethods创建单例
    public static HttpManager getInstance(){
        if(INSTANCE == null){
            synchronized (HttpManager.class){
                if (INSTANCE == null){
                    INSTANCE = new HttpManager();
                }
            }
        }
        return INSTANCE;
    }

    public void getdata(Subscriber<HotMonthModle> subscriber, HashMap<String,String> map){

        testServer.getdata(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
