package com.example.dan.mothertobe.easyHttp;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by dandan on 2016/10/25.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class EasyHttpClite {
    private okhttp3.Request request;
    private EasyHttp.EasyHttpCover cover;
    private Type type;
    public EasyHttpClite(String url, EasyHttp.EasyHttpCover cover,Type type){
        this.cover = cover;
        this.type = type;
        request = new okhttp3.Request.Builder().url(url).get().build();
    }
    public Object excute(){
        return Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                new OkHttpClient().newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        try{
                            subscriber.onNext(cover.just(response,type));
                        }catch (Throwable e){
                            subscriber.onError(e);
                        }

                    }
                });
            }
        });
    }
}
