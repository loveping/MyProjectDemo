package com.example.dan.mothertobe.dbmanager;

import android.content.Context;
import android.util.Log;

import com.example.dan.mothertobe.greendao.UserEntity;
import com.example.dan.mothertobe.greendao.UserEntityDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
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
     * @param userEntity
     * @return
     */
    public boolean insertStudent(UserEntity userEntity){
        boolean flag = false;
        flag = manager.getDaoSession().insert(userEntity) != -1? true : false;
        Log.i("CommonUtils" , "*********insertStudent***result**is******" + flag);
        return flag;
    }

    /**
     * 同时插入多条数据需要开辟线程
     * @param students
     * @return
     */
    public boolean insertMultStudent(List<UserEntity> students){
        boolean flag = false;
        try {
            manager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (UserEntity student:students){
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
    public boolean updataStudent(UserEntity student){
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
    public boolean deletStudent(UserEntity student){
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
            manager.getDaoSession().deleteAll(UserEntity.class);//删除Student表里面所有的数据
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
    public List<UserEntity> listAll(){
        return manager.getDaoSession().loadAll(UserEntity.class);
    }

    /**
     * 按照住建返回单行记录
     * @param key
     * @return
     */
    public UserEntity listOneStudent(long key){
        return manager.getDaoSession().load(UserEntity.class,key);

    }

    public void query1(){
        //使用native sql进行查询操作
        List<UserEntity> list = manager.getDaoSession().queryRaw(UserEntity.class,"where name like ? and _id >?",new String[]{"%李%","1001l"});
        Log.i("******-->>","**"+list);
    }

    /**
     * select * from UserEntity
     */
    public void query2(){
        //查询构建器
         QueryBuilder<UserEntity> builder = manager.getDaoSession().queryBuilder(UserEntity.class);
        builder.where(UserEntityDao.Properties.Age.ge(23)).where(UserEntityDao.Properties.Address.like("北京")).list();
    }
}
