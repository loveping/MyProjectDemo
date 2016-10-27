package com.example.dan.mothertobe.tools;

import com.example.dan.mothertobe.easyHttp.EasyHttpGet;
import com.example.dan.mothertobe.fragment.Modle.TnGou;

import java.util.List;

import rx.Observable;

/**
 * Created by dandan on 2016/10/25.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public interface TestEasyHttpServer {
    @EasyHttpGet(url = "/api/lore/classify")
    public Observable<List<TnGou>> getdata();
}
