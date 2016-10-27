package com.example.dan.mothertobe.easyHttp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * Created by dandan on 2016/10/25.
 * email：435675213@qq.com
 * QQ ：435675213
 */

public class EasyHttp {
    private Builder builder;
    public EasyHttp (Builder builder){
        this.builder = builder;
    }

    public <T>T creat (Class<T> myclass){
        InvocationHandler handler = new CoverJsonHandler(builder.getUrl(),builder.getCover());
        Object ob = Proxy.newProxyInstance(myclass.getClassLoader(),new Class<?>[] {myclass},handler);
        return (T)ob;
    }

    public static final class Builder{
        protected String url ;
        protected  EasyHttpCover cover;

        public Builder url(String url){
            this.url = url;
            return this;
        }
        public Builder addResultCover(EasyHttpCover cover){
            this.cover = cover;
            return this;
        }
        public EasyHttp build(){
            return new EasyHttp(this);
        }
        public String getUrl() {
            return url;
        }

        public EasyHttpCover getCover() {
            return cover;
        }
    }

    public interface EasyHttpCover <T>{
        public T just(Response response, Type type) throws Exception;
    }
}
