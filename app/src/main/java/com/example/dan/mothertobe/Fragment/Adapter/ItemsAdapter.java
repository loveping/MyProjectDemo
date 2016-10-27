package com.example.dan.mothertobe.fragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dan.mothertobe.fragment.Modle.TnGou;
import com.example.dan.mothertobe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dandan on 2016/10/18.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.MyViewHolder> {

    private Context mContext;
    private List<TnGou> list = new ArrayList<TnGou>();
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;


    @Override
    public ItemsAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.list_mathermanual_item, viewGroup, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.MyViewHolder holder, int position) {
        final String title = list.get(position).getTitle();
        final String description = list.get(position).getDescription();
        holder.tv_01.setText(title);
        holder.tv_02.setText(description);

        if (mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }

        if (mOnItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public ItemsAdapter(Context context, List<TnGou> list) {
        this.mContext = context;
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_01;
        TextView tv_02;

        public MyViewHolder(View view) {
            super(view);
            tv_01=(TextView) view.findViewById(R.id. tv_01);
            tv_02=(TextView) view.findViewById(R.id. tv_02);
        }

    }


    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View view,int position);
    }
}
