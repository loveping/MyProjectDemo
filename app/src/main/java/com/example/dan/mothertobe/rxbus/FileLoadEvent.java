package com.example.dan.mothertobe.rxbus;

/**
 * Created by dandan on 2016/11/1.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class FileLoadEvent {
    /**
     * 文件大小
     */
    long total;
    /**
     * 已下载大小
     */
    long progress;

    public long getProgress() {
        return progress;
    }

    public long getTotal() {
        return total;
    }

    public FileLoadEvent(long total, long progress) {
        this.total = total;
        this.progress = progress;
    }
}
