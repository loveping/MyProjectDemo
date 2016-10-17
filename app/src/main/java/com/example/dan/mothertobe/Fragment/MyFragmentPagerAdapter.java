package com.example.dan.mothertobe.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dan.mothertobe.MainActivity;

import java.util.List;

/**
 * Created by dandan on 2016/10/17.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fragment;                         //fragment列表
    private List<String> list_Title;                              //tab名的列表


    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list_fragment,List<String> list_Title) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list_Title = list_Title;
    }

    @Override
    public Fragment getItem(int id) {
        return list_fragment.get(id);
    }

    @Override
    public int getCount() {
        return list_Title.size();
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {

        return list_Title.get(position % list_Title.size());
    }
}
