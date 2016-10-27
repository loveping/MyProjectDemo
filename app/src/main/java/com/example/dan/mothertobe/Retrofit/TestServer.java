package com.example.dan.mothertobe.retrofit;

import com.example.dan.mothertobe.Common.WebService;
import com.example.dan.mothertobe.fragment.Modle.HotMonthModle;

import java.util.HashMap;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by dandan on 2016/10/26.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public interface TestServer {
    @GET(WebService.LIST)
    Observable<HotMonthModle> getdata(@QueryMap HashMap<String,String> map);
}
