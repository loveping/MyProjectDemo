package com.example.dan.mothertobe.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dan.mothertobe.R;
import com.example.dan.mothertobe.dbmanager.CommonUtils;
import com.student.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class GreenDaoTestActivity extends AppCompatActivity {

    private static final String TAG = "GreenDaoTestActivity";
    private Button insert;
    private CommonUtils commonUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao_test);
        insert = (Button)findViewById(R.id.insert);
        commonUtils = new CommonUtils(this);

    }

    //创建数据库的操作
    public void insertData(View view){
        Log.i(TAG,"insert Data");
        Student student = new Student();
        student.setAddress("深圳");
        student.setAge(23);
        student.setName("张三");
        student.setId(1001l);
        commonUtils.insertStudent(student);
        if (commonUtils.insertStudent(student)){
            Toast.makeText(GreenDaoTestActivity.this ,"创建数据成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(GreenDaoTestActivity.this ,"创建数据成功",Toast.LENGTH_SHORT).show();
        }
    }

    //批量插入数据
    public void insertMultData(View view){
        Log.i(TAG,"insert mult Data");
        List<Student> students = new ArrayList<>();
        for (int i =0;i<10;i++){
            Student student = new Student();
            student.setName("李四" + i);
            student.setAge(24+i);
            student.setAddress("广州");
            students.add(student);
        }
        commonUtils.insertMultStudent(students);
        if (commonUtils.insertMultStudent(students)){
            Toast.makeText(GreenDaoTestActivity.this ,"插入多条数据成功",Toast.LENGTH_SHORT).show();
        }
    }

    //更新一条数据
    public void updataData(View view){
        //updata student setname = "jack" where id = "1001"
        Student student = new Student();
        student.setId(1001l);
        student.setAge(25);
        student.setAddress("北京");
        student.setName("jack");
        commonUtils.updataStudent(student);
        if (commonUtils.updataStudent(student)){
            Toast.makeText(GreenDaoTestActivity.this ,"更新单条数据成功",Toast.LENGTH_SHORT).show();
        }
    }

    //删除一条数据
    public  void deleteData(View view){
        Student student = new Student();
        student.setId(1001l);
        //delete from Student where id=1001
        commonUtils.deletStudent(student);
        if (commonUtils.deletStudent(student)){
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
        Student student = commonUtils.listOneStudent(1001l);
        if (student != null){
            student.getAddress();
            Toast.makeText(GreenDaoTestActivity.this ,student.toString(),Toast.LENGTH_SHORT).show();
            Log.i(TAG,student.toString());
        }else {
            Toast.makeText(GreenDaoTestActivity.this ,"查询数据为空",Toast.LENGTH_SHORT).show();
        }

    }

    //查询多条数据
    public void queryAll(View view){
        List<Student> students = commonUtils.listAll();
        if (students.size() != 0){
            Toast.makeText(GreenDaoTestActivity.this ,students.toString(),Toast.LENGTH_SHORT).show();
            Log.i(TAG,students.toString());
        }else {
            Toast.makeText(GreenDaoTestActivity.this ,"查询数据为空",Toast.LENGTH_SHORT).show();
        }

    }

}
