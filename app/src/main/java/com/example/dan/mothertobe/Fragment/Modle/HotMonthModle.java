package com.example.dan.mothertobe.fragment.Modle;

import java.util.List;

/**
 * Created by dandan on 2016/10/27.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HotMonthModle {
    private boolean status;
    private long total;
    private List<HotMonthListModle> tngou;

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

    public List<HotMonthListModle> getTngou() {
        return tngou;
    }

    public void setTngou(List<HotMonthListModle> tngou) {
        this.tngou = tngou;
    }
}
