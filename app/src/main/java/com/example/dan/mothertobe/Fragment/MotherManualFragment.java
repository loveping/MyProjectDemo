package com.example.dan.mothertobe.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dan.mothertobe.Common.WebService;
import com.example.dan.mothertobe.Fragment.Adapter.MatherManualAdapter;
import com.example.dan.mothertobe.Fragment.Modle.MatherManualModle;
import com.example.dan.mothertobe.Fragment.Modle.TnGou;
import com.example.dan.mothertobe.Network.OkHttp3Request;
import com.example.dan.mothertobe.R;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by dandan on 2016/10/17.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class MotherManualFragment extends Fragment {

    private ListView lv_MotherManual;
    private MatherManualAdapter adapter;
    private List<TnGou> modelList = new ArrayList<TnGou>();
    private Context context;
    private ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page_main,container,false);
        context = view.getContext();
        lv_MotherManual = (ListView) view.findViewById(R.id.lv_MotherManual) ;
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        getdata();
        return view;
    }

    private void getdata(){
        OkHttp3Request.get()
                .url(WebService.HEALTHKNOWLEDGE)
                .build()
                .execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {

                        try {
                            JSONObject jo = new JSONObject(s);
                            JSONArray jsonArray = jo.getJSONArray("tngou");
                            Gson gson = new Gson();
                            modelList = gson.fromJson(jsonArray.toString(),new TypeToken<List<TnGou>>() {}.getType());
                            progressBar.setVisibility(View.GONE);
                            adapter = new MatherManualAdapter(context,modelList);
                            lv_MotherManual.setAdapter(adapter);

                        }catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
}
