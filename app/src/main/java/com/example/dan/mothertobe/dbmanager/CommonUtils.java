package com.example.dan.mothertobe.dbmanager;

import android.content.Context;
import android.util.Log;

import com.student.entity.Student;

import java.util.List;

/**
 * 完成对某一张表的具体操作，ORM,操作的对象，Student
 * Created by dandan on 2016/11/7.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class CommonUtils {
    private  DaoManager manager;
    public CommonUtils (Context context){
        manager = DaoManager.getInstance();
        manager.init(context);

    }

    /**
     * 完成对数据库中student 表的插入操作
     * @param student
     * @return
     */
    public boolean insertStudent(Student student){
        boolean flag = false;
        flag = manager.getDaoSession().insert(student) != -1? true : false;
        Log.i("CommonUtils" , "*********insertStudent***result**is******" + flag);
        return flag;
    }

    /**
     * 同时插入多条数据需要开辟线程
     * @param students
     * @return
     */
    public boolean insertMultStudent(List<Student> students){
        boolean flag = false;
        try {
            manager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (Student student:students){
                        manager.getDaoSession().insertOrReplace(student);
                    }
                }
            });
            flag =true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 完成对数据库某一条数据的修改
     * @param student
     * @return
     */
    public boolean updataStudent(Student student){
        boolean flag = false;

        try {
            manager.getDaoSession().update(student);
            flag =true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return flag;

    }

    /**
     * s删除数据
     * @param student
     * @return
     */
    public boolean deletStudent(Student student){
        boolean flag = false;
        try {
            //按照指定的ID进行删除 delete from Student where id = ""
            manager.getDaoSession().delete(student);
            flag = true;
//            manager.getDaoSession().deleteAll();//删除所有的数据
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    /**
     * 删除Student表里面所有的数据
     * @return
     */
    public boolean deleteAllStudent(){
        boolean flag =false;
        try {
            manager.getDaoSession().deleteAll(Student.class);//删除Student表里面所有的数据
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 返回多行记录
     * @return
     */
    public List<Student> listAll(){
        return manager.getDaoSession().loadAll(Student.class);
    }

    /**
     * 按照住建返回单行记录
     * @param key
     * @return
     */
    public Student listOneStudent(long key){
        return manager.getDaoSession().load(Student.class,key);

    }
}
