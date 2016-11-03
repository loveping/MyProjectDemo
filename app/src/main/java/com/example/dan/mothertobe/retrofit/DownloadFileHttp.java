package com.example.dan.mothertobe.retrofit;

import com.example.dan.mothertobe.retrofit.server.DownloadServer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dandan on 2016/11/1.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class DownloadFileHttp {
    private static final int DEFAULT_TIMEOUT= 20;
    private Retrofit retrofit;
    private volatile static DownloadFileHttp INSTANCE;
    private DownloadServer downloadServer;
    private static Call<ResponseBody> call;
    private  static final String baseUrl = "http://hengdawb-app.oss-cn-hangzhou.aliyuncs.com/";


    private DownloadFileHttp (){

        retrofit = new Retrofit.Builder()
                .client(initOkHttpClient())
                .baseUrl(baseUrl)
                .build();
        downloadServer = retrofit.create(DownloadServer.class);
    }

    public static DownloadFileHttp getINSTANCE(){
        if (INSTANCE == null){
            synchronized (DownloadFileHttp.class){
                if (INSTANCE == null){
                    INSTANCE =new DownloadFileHttp();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * 下载文件
     * @param fileName
     * @param callback
     */
    public void loadFileByName(String fileName, FileCallback callback){
        call = downloadServer.loadFile(fileName);
        call.enqueue(callback);
    }
    public static void cancelLoading(){
        if (call !=null&& call.isCanceled() == false){
            call.isCanceled();
        }
    }
    /**
     * 初始化OkHttpClient
     *
     * @return
     */
    private OkHttpClient initOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse
                        .newBuilder()
                        .body(new FileResponseBody(originalResponse))
                        .build();
            }
        });
        return builder.build();
    }
}
