package com.example.dan.mothertobe.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dan.mothertobe.R;
import com.example.dan.mothertobe.dbmanager.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GreenDaoTestActivity extends AppCompatActivity {

    private static final String TAG = "GreenDaoTestActivity";
    private Button insert;
    private CommonUtils commonUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao_test);
        ButterKnife.bind(this);
        insert = (Button)findViewById(R.id.insert);
        commonUtils = new CommonUtils(this);

    }

    //创建数据库的操作
    public void insertData(View view){
        Log.i(TAG,"insert Data");
        UserEntity userEntity = new UserEntity();
        userEntity.setAddress("深圳");
        userEntity.setAge(23);
        userEntity.setName("张三");
        userEntity.setId(1001l);
        commonUtils.insertStudent(userEntity);
        if (commonUtils.insertStudent(userEntity)){
            Toast.makeText(GreenDaoTestActivity.this ,"创建数据成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(GreenDaoTestActivity.this ,"创建数据成功",Toast.LENGTH_SHORT).show();
        }
    }

    //批量插入数据
    public void insertMultData(View view){
        Log.i(TAG,"insert mult Data");
        List<UserEntity> userEntitys = new ArrayList<>();
        for (int i =0;i<10;i++){
            UserEntity userEntity = new UserEntity();
            userEntity.setName("李四" + i);
            userEntity.setAge(24+i);
            userEntity.setAddress("广州");
            userEntitys.add(userEntity);
        }
        commonUtils.insertMultStudent(userEntitys);
        if (commonUtils.insertMultStudent(userEntitys)){
            Toast.makeText(GreenDaoTestActivity.this ,"插入多条数据成功",Toast.LENGTH_SHORT).show();
        }
    }

    //更新一条数据
    public void updataData(View view){
        //updata userEntity setname = "jack" where id = "1001"
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1001l);
        userEntity.setAge(25);
        userEntity.setAddress("北京");
        userEntity.setName("jack");
        commonUtils.updataStudent(userEntity);
        if (commonUtils.updataStudent(userEntity)){
            Toast.makeText(GreenDaoTestActivity.this ,"更新单条数据成功",Toast.LENGTH_SHORT).show();
        }
    }

    //删除一条数据
    public  void deleteData(View view){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1001l);
        //delete from userEntity where id=1001
        commonUtils.deletStudent(userEntity);
        if (commonUtils.deletStudent(userEntity)){
            Toast.makeText(GreenDaoTestActivity.this ,"删除单条数据成功",Toast.LENGTH_SHORT).show();
        }

    }

    //删除所有数据
    public void deleteAllData(View view){
        commonUtils.deleteAllStudent();
        if (commonUtils.deleteAllStudent()){
            Toast.makeText(GreenDaoTestActivity.this ,"删除所有数据成功",Toast.LENGTH_SHORT).show();
        }
    }
    //查询一条数据
    public void queryOne(View view){
        UserEntity userEntity = commonUtils.listOneStudent(1001l);
        if (userEntity != null){
            userEntity.getAddress();
            Toast.makeText(GreenDaoTestActivity.this ,userEntity.toString(),Toast.LENGTH_SHORT).show();
            Log.i(TAG,userEntity.toString());
        }else {
            Toast.makeText(GreenDaoTestActivity.this ,"查询数据为空",Toast.LENGTH_SHORT).show();
        }

    }

    //查询多条数据
    public void queryAll(View view){
        List<UserEntity> userEntitys = commonUtils.listAll();
        if (userEntitys.size() != 0){
            Toast.makeText(GreenDaoTestActivity.this ,userEntitys.toString(),Toast.LENGTH_SHORT).show();
            Log.i(TAG,userEntitys.toString());
        }else {
            Toast.makeText(GreenDaoTestActivity.this ,"查询数据为空",Toast.LENGTH_SHORT).show();
        }

    }

    //使用复合条件进行查询
    public void queryBuilder(View view){

    }

}
