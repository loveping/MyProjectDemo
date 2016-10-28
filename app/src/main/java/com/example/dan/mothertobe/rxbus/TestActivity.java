package com.example.dan.mothertobe.rxbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dan.mothertobe.R;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class TestActivity extends AppCompatActivity {

    private CompositeSubscription compositeSubscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        RxBus.getnInstance().post(new TestEvent("001","小明"));

        Subscription rxSbscription = RxBus.getnInstance()
               .toObserverable(TestEvent.class)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TestEvent>() {
                    @Override
                    public void call(TestEvent testEvent) {
                        Toast.makeText(TestActivity.this,"hello this is RxBus"+testEvent.getId(),Toast.LENGTH_SHORT).show();
                    }
                });
        addSuscription(rxSbscription);
    }

    public void addSuscription(Subscription subscription){
        if (this.compositeSubscription == null){
            this.compositeSubscription = new CompositeSubscription();

        }
        this.compositeSubscription.add(subscription);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TestActivity.class.getSimpleName(), "onDestroy");
        if (this.compositeSubscription != null) {
            //取消注册，以避免内存泄露
            this.compositeSubscription.unsubscribe();
        }
    }
}
