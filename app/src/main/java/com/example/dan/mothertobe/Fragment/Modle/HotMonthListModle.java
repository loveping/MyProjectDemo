package com.example.dan.mothertobe.fragment.Modle;

/**
 * Created by dandan on 2016/10/27.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class HotMonthListModle {
    /**
     * "status": true,
     "total": 504,
     "tngou": [
     {
     "count": 14,
     "description": "视力突然下降的六大原因！你知道吗？ 这个病就像一个“隐形杀手”，早期症状不明显，但对眼睛的攻击力却相当强大，当出现视力改变时，很多人已经永久性地丧失了部分视觉功能",
     "fcount": 0,
     "id": 20580,
     "img": "/lore/161025/e79d48d264d4aadc16e66423b6baac6d.jpg",
     "keywords": "隐形眼镜 视物模糊 视力 青光眼 眼睛 ",
     "loreclass": 2,
     "rcount": 0,
     "time": 1477395057000,
     "title": "美国《预防》杂志网站近日总结了造成视力突然下降的六大原因"
     */
    private int count;
    private String description;
    private int fcount;
    private int id;
    private String img;
    private String keywords;
    private int loreclass;
    private int rcount;
    private String time;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getLoreclass() {
        return loreclass;
    }

    public void setLoreclass(int loreclass) {
        this.loreclass = loreclass;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
