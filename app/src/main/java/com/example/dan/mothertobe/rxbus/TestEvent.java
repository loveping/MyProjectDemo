package com.example.dan.mothertobe.rxbus;

/**
 * Created by dandan on 2016/10/28.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class TestEvent {
    private String id;
    private String name;
    public TestEvent(String id ,String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
