package com.example.dan.mothertobe.fragment.Modle;

/**
 * Created by dandan on 2016/10/19.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class CookListModle {
    /**
     *  "count": 23,
     "description": "奶油奶酪放进微波炉里打软，36度左右，然后和融化后的黄油一起放进一个盆里打发，有点分离也没有关系2",
     "fcount": 0,
     "food": "奶油奶酪,黄油,蛋黄,玉米淀粉,牛奶,蛋白",
     "id": 81340,
     "images": "/cook/080400/418f411ac2bc37d15d2f10d027d636c9.jpg,/cook/080400/418f411ac2bc37d15d2f10d027d636c9.jpg",
     "img": "/cook/080400/f6c878e710855eaf2ff45a2ed0f40b16.jpg",
     "keywords": "搅拌 蛋白 里面 加进 砂糖 ",
     "name": "苏芙蕾芝士蛋糕",
     "rcount": 0
     */

    private int count;
    private String description;
    private int fcount;
    private String food;
    private int id;
    private String images;
    private String img;
    private String keywords;
    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    private int rcount;
}
