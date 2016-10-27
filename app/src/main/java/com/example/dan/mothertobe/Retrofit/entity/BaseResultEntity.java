package com.example.dan.mothertobe.retrofit.entity;

/**
 * Created by dandan on 2016/10/26.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class BaseResultEntity<T> {
    //判断标准
    private int resultCode;
    //提示信息
    private String resultMessage;

    //显示数据（用户关心的数据）
    private T data;
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }


}
