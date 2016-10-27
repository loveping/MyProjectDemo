package com.example.dan.mothertobe.fragment.Modle;

import java.util.List;

/**
 * Created by dandan on 2016/10/17.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class MatherManualModle {
    /**
     *  "status": true,
     "tngou": [
     {
     "description": "减肥瘦身,美丽一生,减肥资讯 瘦身资讯 ,减肥瘦身健康知识,减肥瘦身信息专题",
     "id": 11,
     "keywords": "减肥瘦身",
     "name": "减肥瘦身",
     "seq": 1,
     "title": "减肥瘦身"
     },
     */

    private boolean status;
    private List<TnGou> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<TnGou> getTngou() {
        return tngou;
    }

    public void setTngou(List<TnGou> tngou) {
        this.tngou = tngou;
    }
}
