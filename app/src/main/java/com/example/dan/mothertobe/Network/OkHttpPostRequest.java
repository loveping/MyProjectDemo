package com.example.dan.mothertobe.network;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

public class OkHttpPostRequest {
	
	private String url;
    private okhttp3.Request request;
    private RequestBody mRequestBody;
    private PosunOkHttp3CallBack mPosunOkHttp3CallBack;
    private OkHttpHandler mOkHttpHandler;
    protected OkHttpPostRequest(String url,RequestBody mRequestBody) {
        this.url = url;
        this.mRequestBody=mRequestBody;
    }
    protected OkHttpPostRequest builde() {
        request= new okhttp3.Request.Builder().url(url).post(mRequestBody).build();
       return this;
    }

//    public void execute(PosunOkHttp3CallBack mPosunOkHttp3CallBack){
//        this.mPosunOkHttp3CallBack=mPosunOkHttp3CallBack;
//        if (CheckNet.checkNet(mPosunOkHttp3CallBack.getAcitiveContext())) {
//        	OkHttp3Request.getOkHttpClient().newCall(request).enqueue(this);
//		}
//    }


    public Observable<String> execute(){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                OkHttp3Request.getOkHttpClient().newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        subscriber.onNext(response.body().string());
                    }
                });
            }
        });
    }
    public void handleThread(){
        mOkHttpHandler=OkHttpHandler.getOkHttpHandler().setCallback(mPosunOkHttp3CallBack);
    }
//    @Override
//    public void onFailure(Call call, IOException e) {
//    	if (mOkHttpHandler == null) {
//    		mPosunOkHttp3CallBack.Onfailed(e, url);
//		}else {
//			HandlerEntity entit=new HandlerEntity();
//            entit.setObject1(e);
//            entit.setUrl(url);
//            try {
//                mOkHttpHandler.handleResponse(entit);
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//		}
//    }
//    @Override
//    public void onResponse(Call call, Response response) throws IOException {
//
//    	if (mOkHttpHandler == null) {
//    		mPosunOkHttp3CallBack.OnSuccess(new GsonRespone().setResult(response.body().string()),url);
//		}else {
//			HandlerEntity entit=new HandlerEntity();
//            entit.setObject1(response.body().string());
//            entit.setUrl(url);
//
//            try {
//				mOkHttpHandler.handleResponse(entit);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//    }

}
