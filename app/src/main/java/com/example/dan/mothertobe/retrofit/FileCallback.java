package com.example.dan.mothertobe.retrofit;

import com.example.dan.mothertobe.rxbus.DownloadFileRxBus;
import com.example.dan.mothertobe.rxbus.FileLoadEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dandan on 2016/11/1.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public abstract class FileCallback implements Callback<ResponseBody>{
    /**
     * 订阅下载进度
     */
    private CompositeSubscription rxSubscriptions = new CompositeSubscription();
    /**
     * 目标文件存储的文件夹路径
     */
    private String destFileDir;
    /**
     * 目标文件存储的文件名
     */
    private String destFileName;

    /**
     * 目标文件
     */
    private ResponseBody responseBody;

    public FileCallback(String destFileDir, String destFileName) {
        this.destFileDir = destFileDir;
        this.destFileName = destFileName;
        subscribeLoadProgress();
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            saveFile(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onSuccess(File file) {
        unsubscribe();
    }

    public abstract void progress(long progress, long total);

    /**
     * 保存
     *
     * @param response
     * @return
     * @throws IOException
     */
    public File saveFile(Response<ResponseBody> response) throws IOException {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            File dir = new File(destFileDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, destFileName);
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            onSuccess(file);
            return file;
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * 订阅文件下载进度
     */
    private void subscribeLoadProgress() {
        rxSubscriptions.add(DownloadFileRxBus.getDefault()
                .toObservable(FileLoadEvent.class)
                .onBackpressureBuffer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<FileLoadEvent>() {
                    @Override
                    public void call(FileLoadEvent fileLoadEvent) {
                        progress(fileLoadEvent.getProgress(), fileLoadEvent.getTotal());
                    }
                }));
    }

    /**
     * 取消订阅，防止内存泄漏
     */
    private void unsubscribe() {
        if (!rxSubscriptions.isUnsubscribed()) {
            rxSubscriptions.unsubscribe();
        }
    }
}
