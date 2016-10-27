package com.example.dan.mothertobe.retrofit;

import com.example.dan.mothertobe.retrofit.entity.BaseResultEntity;
import com.example.dan.mothertobe.retrofit.exception.HttpTimeException;
import com.example.dan.mothertobe.retrofit.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by dandan on 2016/10/26.
 * email：435675213@qq.com
 * QQ ：435675213
 * 请求数据统一封装
 */

public abstract class BaseEntity<T> implements Func1<BaseResultEntity<T>, T >{

    //rx生命周期管理
    private RxAppCompatActivity rxAppCompatActivity;
    /*回调*/
    private HttpOnNextListener listener;
    /*是否能取消加载框*/
    private boolean cancel;
    /*是否显示加载框*/
    private boolean showProgress;


    public BaseEntity(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        setListener(listener);
        setRxAppCompatActivity(rxAppCompatActivity);
        setShowProgress(true);
    }

    /**
     * s设置参数
     * @param tBaseResultEntity
     * @return
     */
    public abstract Observable getObservable(TestServer methods);
    public void setRxAppCompatActivity(RxAppCompatActivity rxAppCompatActivity) {
        this.rxAppCompatActivity = rxAppCompatActivity;
    }
    public boolean isShowProgress() {
        return showProgress;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public HttpOnNextListener getListener() {
        return listener;
    }

    public void setListener(HttpOnNextListener listener) {
        this.listener = listener;
    }
    /*
     * 获取当前rx生命周期
     * @return
     */
    public RxAppCompatActivity getRxAppCompatActivity() {
        return rxAppCompatActivity;
    }

    @Override
    public T call(BaseResultEntity<T> httpResult) {
        if (httpResult.getResultCode() == 0){
            throw new HttpTimeException(httpResult.getResultMessage());
        }
        return httpResult.getData();
    }
}
