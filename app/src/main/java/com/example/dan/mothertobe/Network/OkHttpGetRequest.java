package com.example.dan.mothertobe.Network;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

public class OkHttpGetRequest{
	
	private String url;
    private okhttp3.Request request;
    private int type = 0;
    private String file;
    private int buffer_size=2048;
    private String filename="";
    private OkHttpHandler mOkHttpHandler;
    
    private PosunOkHttp3CallBack mPosunOkHttp3CallBack;
    protected OkHttpGetRequest(String url) {
        this.url = url;
    }

    protected OkHttpGetRequest Builder() {
        request = new okhttp3.Request.Builder().url(url).get().build();
        
 
        return this;
    }
    public OkHttpGetRequest filepath(String path){
        this.file=path;
        return this;
    }
    public OkHttpGetRequest type(int type) {
        this.type = type;
        return this;
    }
//
//    public OkHttpGetRequest execute(PosunOkHttp3CallBack mPosunOkHttp3CallBack) {
//        this.mPosunOkHttp3CallBack = mPosunOkHttp3CallBack;
//
//        if (CheckNet.checkNet(mPosunOkHttp3CallBack.getAcitiveContext())) {
//            if (filename == null || filename.trim().equals("")) {
//                filename = String.valueOf(System.currentTimeMillis());
//            }
//            OkHttp3Request.getOkHttpClient().newCall(request).enqueue(this);
//        }
//        return this;
//    }
    public OkHttpGetRequest buffer_size(int size){
        this.buffer_size=size;
        return this;
    }

    public Observable<String> downImage(String path){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });
    }

    public Observable<String> execute(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {


                    if (filename == null || filename.trim().equals("")) {
                        filename = String.valueOf(System.currentTimeMillis());
                    }
                    OkHttp3Request.getOkHttpClient().newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            {
                                subscriber.onError(e);
                            }
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (type == OkHttp3Request.REQUEST_STRING) {

                                subscriber.onNext(response.body().string());

                            } else if (type == OkHttp3Request.REQUEST_BUFFER) {
                                InputStream inputStream = response.body().byteStream();
                                FileOutputStream fileOutputStream = new FileOutputStream(file==null?new File(OkHttp3Request.defult_file+filename):new File(OkHttp3Request.defult_file+file));
                                byte[] buffer = new byte[buffer_size];
                                int len = 0;
                                while ((len = inputStream.read(buffer)) != -1) {
                                    fileOutputStream.write(buffer, 0, len);
                                }
                                fileOutputStream.flush();
                                Log.d("dan", "文件下载成功...");
                            }
                        }
                    });
                }

        });
    }
//    @Override
//    public void onFailure(Call call, IOException e) {
//        if(mOkHttpHandler==null){
//            mPosunOkHttp3CallBack.Onfailed(e, url);
//        }else{
//            HandlerEntity entit=new HandlerEntity();
//            entit.setObject1(e);
//            entit.setUrl(url);
//            try {
//                mOkHttpHandler.handleResponse(entit);
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//        }
//
//    }
//    public void handleThread(){
//
//        mOkHttpHandler=OkHttpHandler.getOkHttpHandler().setCallback(mPosunOkHttp3CallBack);
//    }
//
//    @Override
//    public void onResponse(Call call, Response response) throws IOException {
//        if (type == OkHttp3Request.REQUEST_STRING) {
//            if(mOkHttpHandler==null){
//                mPosunOkHttp3CallBack.OnSuccess(new GsonRespone().setResult(response.body().string()), url);
//            }else{
//                HandlerEntity entit=new HandlerEntity();
//                entit.setObject1(response.body().string());
//                entit.setUrl(url);
//                try {
//                    mOkHttpHandler.handleResponse(entit);
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//        } else if (type == OkHttp3Request.REQUEST_BUFFER) {
//            InputStream inputStream = response.body().byteStream();
//            FileOutputStream fileOutputStream = new FileOutputStream(file==null?new File(OkHttp3Request.defult_file+filename):new File(OkHttp3Request.defult_file+file));
//            byte[] buffer = new byte[buffer_size];
//            int len = 0;
//            while ((len = inputStream.read(buffer)) != -1) {
//                fileOutputStream.write(buffer, 0, len);
//            }
//            fileOutputStream.flush();
//            Log.d("qing", "文件下载成功...");
//        }
//
//    }
}
