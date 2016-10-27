package com.example.dan.mothertobe.retrofit;

import com.example.dan.mothertobe.Common.WebService;
import com.example.dan.mothertobe.fragment.Modle.HotReonthModle;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by dandan on 2016/10/27.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public interface HotRecommentServer {

    @GET(WebService.QUERYNEWSLIST)
    Observable<HotReonthModle> getdata(@Query("iDisplayStart") int start, @Query("iDisplayLength") int end);
}
