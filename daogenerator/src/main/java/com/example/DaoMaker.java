package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

import java.io.IOException;

public class DaoMaker {
    public static void main(String [] args) throws Exception {

        //生成数据库的实体类 XX.entity对应的是数据库的表
        Schema schema = new Schema(1,"com.student.entity");
        addStudent(schema);
        schema.setDefaultJavaPackageDao("com.student.dao");
        try {
            new DaoGenerator().generateAll(schema,"G:\\RXjava\\MotherToBe\\app\\src\\main\\java-gen");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //创建数据库的表
    private static void addStudent(Schema schema){
        //创建数据库的表
        Entity entity = schema.addEntity("Student");

        entity.addIdProperty();//创建数据库的主键，是int类型

        entity.addStringProperty("name");//对应数据库的列
        entity.addStringProperty("address");//对应数据库的列
        entity.addIntProperty("age");//对应数据库的列

    }
}
