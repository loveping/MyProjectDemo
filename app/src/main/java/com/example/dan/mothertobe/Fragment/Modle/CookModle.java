package com.example.dan.mothertobe.fragment.Modle;

import java.util.List;

/**
 * Created by dandan on 2016/10/19.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class CookModle {

    /**
     *  "status": true,
     "total": 101254,
     "tngou":
     */

    private boolean status;
    private long total;
    private List<CookListModle> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<CookListModle> getTngou() {
        return tngou;
    }

    public void setTngou(List<CookListModle> tngou) {
        this.tngou = tngou;
    }
}
