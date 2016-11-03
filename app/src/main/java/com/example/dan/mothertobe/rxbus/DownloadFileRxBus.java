package com.example.dan.mothertobe.rxbus;


import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by dandan on 2016/11/1.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class DownloadFileRxBus {
    private static volatile DownloadFileRxBus INSTANCE;
    private final Subject<Object,Object> bus;
    private DownloadFileRxBus(){
        bus = new SerializedSubject<>(PublishSubject.create());
    }
    /**
     * 单例RxBus
     *
     * @return
     */
    public static DownloadFileRxBus getDefault() {
        DownloadFileRxBus rxBus = INSTANCE;
        if (INSTANCE == null) {
            synchronized (DownloadFileRxBus.class) {
                rxBus = INSTANCE;
                if (INSTANCE == null) {
                    rxBus = new DownloadFileRxBus();
                    INSTANCE = rxBus;
                }
            }
        }
        return rxBus;
    }

    /**
     * 发送一个新事件
     *
     * @param o
     */
    public void post(Object o) {
        bus.onNext(o);
    }

    /**
     * 返回特定类型的被观察者
     *
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }
}
