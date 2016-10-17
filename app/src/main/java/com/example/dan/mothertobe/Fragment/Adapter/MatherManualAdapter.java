package com.example.dan.mothertobe.Fragment.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dan.mothertobe.Fragment.Modle.MatherManualModle;
import com.example.dan.mothertobe.Fragment.Modle.TnGou;
import com.example.dan.mothertobe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dandan on 2016/10/17.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class MatherManualAdapter extends BaseAdapter{

    private Context mContext;
    private List<TnGou> list = new ArrayList<TnGou>();

    public  MatherManualAdapter(Context mContext, List<TnGou> list){
        this.list = list;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        Log.i("*********************",list.get(0).getDescription());
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_mathermanual_item, viewGroup, false);
            holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
            holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.i("*********************",list.get(0).getDescription());

        holder.tv_01.setText(list.get(i).getTitle());
        holder.tv_02.setText(list.get(i).getDescription());
        return convertView;
    }

    /**
     * 列表末添加数据
     */
    public void addItemsToEnd(List<TnGou> mods) {
        if (mods != null) {
            for (TnGou mod : mods) {
                this.list.add(this.list.size(), mod);
               // this.list.addAll(list);
            }
            this.notifyDataSetChanged();
        }
    }

    class ViewHolder {
        public TextView tv_01;
        public TextView tv_02;
    }
}
