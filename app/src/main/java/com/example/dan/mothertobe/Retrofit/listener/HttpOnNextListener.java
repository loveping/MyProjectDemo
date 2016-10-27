package com.example.dan.mothertobe.retrofit.listener;

/**
 * Created by dandan on 2016/10/26.
 * email：435675213@qq.com
 * QQ ：435675213
 * 成功回调处理
 */

public abstract class HttpOnNextListener<T> {

    /**
     * 成功后回调方法
     */
    public abstract void onNext(T t);

    /**
     * 失败或者错误方法
     * 主动调用，更加灵活
     */
    public void onError(Throwable e){}

    /**
     * 取消回调
     */
    public void onCancel(){}
}
