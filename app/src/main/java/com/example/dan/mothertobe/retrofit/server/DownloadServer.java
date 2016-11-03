package com.example.dan.mothertobe.retrofit.server;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by dandan on 2016/11/1.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public interface DownloadServer {
    /**
     * 下载数据、资源
     */
    @GET("{fileName}")
    Call<ResponseBody> loadFile(@Path("fileName") String fileName);
}
