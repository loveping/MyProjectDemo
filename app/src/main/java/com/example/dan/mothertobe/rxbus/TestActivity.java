package com.example.dan.mothertobe.rxbus;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dan.mothertobe.R;
import com.example.dan.mothertobe.retrofit.DataManager;
import com.example.dan.mothertobe.retrofit.DownloadFileHttp;
import com.example.dan.mothertobe.retrofit.FileCallback;
import com.example.dan.mothertobe.retrofit.FileResponseBody;
import com.example.dan.mothertobe.retrofit.HDialogBuilder;

import java.io.File;

import okhttp3.ResponseBody;
import retrofit2.Call;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class TestActivity extends AppCompatActivity {

    private CompositeSubscription compositeSubscription;
    private Subscriber subscriber;
    private String baseUrl = "http://hengdawb-app.oss-cn-hangzhou.aliyuncs.com/";
    private String fileName = "app-debug.apk";

    //获得SD卡的绝对路径
    private String fileStoreDir = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator+ "MyApp";

    private String fileStoreName = fileName;
    private HDialogBuilder hDialogBuilder;
    private TextView txtProgress;
    private TextView tv_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv_download = (TextView) findViewById(R.id.tv_download);
//        RxBus.getnInstance().post(new TestEvent("001","小明"));
//
//        Subscription rxSbscription = RxBus.getnInstance()
//               .toObserverable(TestEvent.class)
//               .subscribeOn(Schedulers.io())
//               .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<TestEvent>() {
//                    @Override
//                    public void call(TestEvent testEvent) {
//                        Toast.makeText(TestActivity.this,"hello this is RxBus"+testEvent.getId(),Toast.LENGTH_SHORT).show();
//                    }
//                });
//        addSuscription(rxSbscription);
        showLoadingDialog();
        downloadfile();


    }

    private void downloadfile(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<font> ");
        stringBuffer.append("下载完成"+"<br>");
        stringBuffer.append("下载路径为："+fileStoreDir);
        stringBuffer.append("</font>");
        DownloadFileHttp.getINSTANCE().loadFileByName(fileName, new FileCallback(fileStoreDir, fileStoreName) {
            @Override
            public void progress(long progress, long total) {
                updateProgress(progress, total);
            }

            @Override
            public void onSuccess(File file) {
                super.onSuccess(file);
                hDialogBuilder.dismiss();
                tv_download.setText(Html.fromHtml(stringBuffer.toString()));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                hDialogBuilder.dismiss();
                call.cancel();
            }
        });
    }
//    public void addSuscription(Subscription subscription){
//        if (this.compositeSubscription == null){
//            this.compositeSubscription = new CompositeSubscription();
//
//        }
//        this.compositeSubscription.add(subscription);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.d(TestActivity.class.getSimpleName(), "onDestroy");
//        if (this.compositeSubscription != null) {
//            //取消注册，以避免内存泄露
//            this.compositeSubscription.unsubscribe();
//        }
//    }



    /**
     * 更新下载进度
     *
     * @param progress
     * @param total
     */
    private void updateProgress(long progress, long total) {
        txtProgress.setText(String.format("正在下载：(%s/%s)",
                DataManager.getFormatSize(progress),
                DataManager.getFormatSize(total)));
    }

    /**
     * 显示下载对话框
     */
    private void showLoadingDialog() {
        txtProgress = (TextView) View.inflate(TestActivity.this, R.layout.layout_hd_dialog_custom_tv, null);
        hDialogBuilder = new HDialogBuilder(TestActivity.this);
        hDialogBuilder.setCustomView(txtProgress)
                .title("下载")
                .nBtnText("取消")
                .titleColor(R.color.black)
                .nBtnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hDialogBuilder.dismiss();
                        DownloadFileHttp.cancelLoading();
                    }
                })
                .show();
    }
}
