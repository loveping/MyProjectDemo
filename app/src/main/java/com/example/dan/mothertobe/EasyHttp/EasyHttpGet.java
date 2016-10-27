package com.example.dan.mothertobe.easyHttp;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dandan on 2016/10/25.
 * email：435675213@qq.com
 * QQ ：435675213
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface EasyHttpGet {
    public String url() default "";
}
