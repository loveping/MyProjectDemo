package com.example.dan.mothertobe.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dan.mothertobe.R;

/**
 * Created by dandan on 2016/10/17.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HotThisMonthFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page_main,container,false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("第00页");
        return view;
    }
}
