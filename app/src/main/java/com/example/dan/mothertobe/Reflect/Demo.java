package com.example.dan.mothertobe.reflect;

import java.lang.reflect.Method;

/**
 * Created by dandan on 2016/10/24.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class Demo {

    public int add(int param1, int param2)
    {
        return param1 + param2;

    }

    public String echo(String message)
    {
        return "Hello: " + message;
    }
    public static void main(String[] args) throws Exception{
//        Class<?> demo1 = null;
//        Class<?> demo2 = null;
//        Class<?> demo3 = null;
//        try {
//            //一般尽量采用这种形式,若存在则加载，否则新建
//            demo1 = Class.forName("com.example.dan.mothertobe.Reflect.Demo");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        demo2 = new Demo().getClass();
//        demo3 = Demo.class;
//
//        System.out.println("类名称   " + demo1.getName());
//        System.out.println("类名称   " + demo2.getName());
//        System.out.println("类名称   " + demo3.getName());
//
//        //获得字符串所标识的类的class对象
//        Class<?> classType = Class.forName("java.lang.String");//在此处传入字符串指定类名，所以参数获取可以是一个运行期的行为，可以用args[0]
//
//        //返回class对象所对应的类或接口中，所声明的所有方法的数组（包括私有方法）
//        Method[] methods = classType.getDeclaredMethods();
//
//        //遍历输出所有方法声明
//        for(Method method : methods)
//        {
//            System.out.println("****   "+method);
//        }

        // 第一步，获取Class对象
        // 前面用的方法是：Class.forName()方法获取
        // 这里用第二种方法，类名.class
        Class<?> classType = Demo.class;

        //生成新的对象：用newInstance();
        Object demo = classType.newInstance();
        System.out.println(demo instanceof Demo);//输出为true

        //通过反射调用方法
        //首先需要获得与该方法对应的Method对象
        //第一个参数是方法名，第二个参数是这个方法所需要的Class对象数组
        Method addMethod = classType.getMethod("add",new Class[] {int.class,int.class});
        //调用目标方法
        Object result = addMethod.invoke(demo,new Object[] {1,2});
        System.out.println(result);

        //调用第二个方法
        Method echoMethod = classType.getDeclaredMethod("echo", new Class[]{String.class});
        Object result2 = echoMethod.invoke(demo, new Object[]{"Tom"});
        System.out.println(result2);
    }

}

class hello{

}