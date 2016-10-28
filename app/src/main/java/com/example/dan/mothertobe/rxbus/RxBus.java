package com.example.dan.mothertobe.rxbus;


import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by dandan on 2016/10/28.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class RxBus {
    private static volatile RxBus mInstance;
    private  Subject bus;
    public RxBus(){
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBus getnInstance(){
        RxBus rxBus2 = mInstance;
        if (mInstance == null){
            synchronized (RxBus.class){
                rxBus2 = mInstance;
                if (mInstance == null){
                    rxBus2 = new RxBus();
                    mInstance = rxBus2;
                }
            }
        }
        return mInstance;
    }
    /**
     * 发送消息
     */
    public void post(Object object){
        bus.onNext(object);
    }

    /**
     * 接收消息
     */

    public <T>Observable toObserverable(Class<T> eventType){
        return bus.ofType(eventType);
    }
}
