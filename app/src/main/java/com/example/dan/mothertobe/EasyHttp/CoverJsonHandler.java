package com.example.dan.mothertobe.easyHttp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Observable;

/**
 * Created by dandan on 2016/10/25.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class CoverJsonHandler implements InvocationHandler{
    private String url;
    private EasyHttp.EasyHttpCover cover;
    public CoverJsonHandler(String url,EasyHttp.EasyHttpCover cover){
        super();
        this.cover = cover;
        this.url = url;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        EasyHttpGet easyHttpGet = method.getAnnotation(EasyHttpGet.class);
        try {
            if (((ParameterizedType)method.getGenericReturnType()).getRawType().equals(Observable.class)){
                return new EasyHttpClite(url+easyHttpGet.url(),cover,((ParameterizedType) method.getGenericReturnType()).getActualTypeArguments()[0]).excute();
            }
        }catch (Exception e){

        }
        return new EasyHttpClite(url,cover,method.getGenericReturnType()).excute();
    }
}
