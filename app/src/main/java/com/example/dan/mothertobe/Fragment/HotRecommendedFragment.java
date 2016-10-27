package com.example.dan.mothertobe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dan.mothertobe.fragment.Modle.HotReonthModle;
import com.example.dan.mothertobe.R;
import com.example.dan.mothertobe.retrofit.HotRecommendRequest;

import rx.Subscriber;

/**
 * Created by dandan on 2016/10/17.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HotRecommendedFragment extends Fragment {

    private Subscriber subscriber;
    private TextView tv_01;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot_recommend,container,false);
        tv_01 = (TextView)view.findViewById(R.id.tv_01) ;
        getdata();
        return view;
    }

    private void getdata(){
        subscriber =new Subscriber<HotReonthModle>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("************error     ",e.getMessage());
            }

            @Override
            public void onNext(HotReonthModle list) {
                tv_01.setText(list.getInfo().get(0).getTitle());
            }
        };
        HotRecommendRequest.getINSTANCE().getdata(subscriber,1,10);
    }
}
