package com.example.dan.mothertobe.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dan.mothertobe.Common.WebService;
import com.example.dan.mothertobe.Fragment.Adapter.ItemsAdapter;
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

public class MotherManualFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private ListView lv_MotherManual;
    private MatherManualAdapter adapter;
    private List<TnGou> modelList = new ArrayList<TnGou>();
    private Context context;
    private ProgressBar progressBar;


    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private ItemsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page_main,container,false);
        context = view.getContext();
        lv_MotherManual = (ListView) view.findViewById(R.id.lv_MotherManual) ;
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        LinearLayoutManager  layoutManager = new LinearLayoutManager (context);
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);

        //mRecyclerView.addItemDecoration(new DividerDecoration(this));
        mSwipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                    mSwipeRefreshLayout.setRefreshing(true);
            }
        });

        mAdapter = new ItemsAdapter(context,modelList);

        mRecyclerView.setAdapter( mAdapter);

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
                            List<TnGou> modelList1 = new ArrayList<TnGou>();
                            modelList1 = gson.fromJson(jsonArray.toString(),new TypeToken<List<TnGou>>() {}.getType());

                            for (int i = 0; i < modelList1.size(); i++) {
                                modelList.add(modelList1.get(i));
                            }

                            mAdapter.notifyDataSetChanged();

                            mSwipeRefreshLayout.post(new Runnable() {
                                @Override
                                public void run() {

                                    if (modelList.size() == 0){

                                        mSwipeRefreshLayout.setRefreshing(true);
                                    }else {

                                        mSwipeRefreshLayout.setRefreshing(false);
                                    }
                                }
                            });

                            //设置增加或删除条目的动画
                            mRecyclerView.setItemAnimator(new DefaultItemAnimator());

                            setListener();
                        }catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

    @Override
    public void onRefresh() {
        modelList.clear();
        getdata();
    }


    private void setListener(){
        mAdapter.setOnItemClickListener(new ItemsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "click " + modelList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnItemLongClickListener(new ItemsAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(context,"long click "+modelList.get(position).getDescription(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
