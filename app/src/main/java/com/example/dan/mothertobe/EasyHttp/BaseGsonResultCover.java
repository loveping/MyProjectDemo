package com.example.dan.mothertobe.easyHttp;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by dandan on 2016/10/25.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class BaseGsonResultCover implements EasyHttp.EasyHttpCover{
    @Override
    public Object just(Response response, Type type) throws Exception {
        return new Gson().fromJson(response.body().string(),type);
    }

    public static BaseGsonResultCover creat(){
        return new BaseGsonResultCover();
    }
}
