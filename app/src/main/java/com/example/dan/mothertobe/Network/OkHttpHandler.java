package com.example.dan.mothertobe.network;

import android.os.Looper;
import android.os.Message;

public class OkHttpHandler extends android.os.Handler{

	 private PosunOkHttp3CallBack PosunOkHttp3CallBack;
	    @Override
	    public void handleMessage(Message msg) {
	         if(msg.obj!=null){
	             HandlerEntity mHandlerEntity=(HandlerEntity)msg.obj;
	             if(mHandlerEntity.getObject1() instanceof String){
	                 PosunOkHttp3CallBack.OnSuccess(new GsonRespone().setResult((String)mHandlerEntity.getObject1()), mHandlerEntity.getUrl());
	             }else{
	                 PosunOkHttp3CallBack.Onfailed((Exception)mHandlerEntity.getObject1(),mHandlerEntity.getUrl());
	             }

	         }
	        super.handleMessage(msg);
	    }
	    private OkHttpHandler(Looper loop){
	        super(loop);
	    }
	    public OkHttpHandler setCallback(PosunOkHttp3CallBack PosunOkHttp3CallBack){
	        this.PosunOkHttp3CallBack=PosunOkHttp3CallBack;
	        return this;
	    }
	    public static OkHttpHandler getOkHttpHandler(){
	        return new OkHttpHandler(Looper.myLooper());
	    }
	    public void handleResponse(HandlerEntity obj) throws Exception{
	        if(PosunOkHttp3CallBack==null){
	            throw  new Exception("PosunOkHttp3CallBack not allowed null");
	        }
	        Message msg=this.obtainMessage();
	        msg.obj=obj;
	        this.sendMessage(msg);
	    }
}
