package com.example.dan.mothertobe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dan.mothertobe.fragment.Modle.HotMonthModle;
import com.example.dan.mothertobe.R;
import com.example.dan.mothertobe.retrofit.HttpManager;

import java.util.HashMap;

import rx.Subscriber;

/**
 * Created by dandan on 2016/10/17.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HotThisMonthFragment extends Fragment {

    private TextView tv_test;
    private Subscriber subscriber;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot_month,container,false);
        tv_test = (TextView) view.findViewById(R.id.tv_test);
        getdata();
        return view;
    }


    private void getdata(){

        subscriber = new Subscriber<HotMonthModle>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("HotThisMonthFragment**********    ", e.getMessage());
            }

            @Override
            public void onNext(HotMonthModle hotMonthModle) {
                tv_test.setText(hotMonthModle.getTngou().get(2).getDescription());
            }
        };
        HashMap<String,String> map = new HashMap<>();
        map.put("id","2");
        HttpManager.getInstance().getdata(subscriber,map);

    }
}
