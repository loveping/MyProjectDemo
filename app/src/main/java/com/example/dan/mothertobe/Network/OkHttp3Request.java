package com.example.dan.mothertobe.network;

import android.content.Context;

import java.io.File;

import okhttp3.OkHttpClient;

public class OkHttp3Request{
	
		private static Context mContext;
		public static int REQUEST_STRING = 0;
	    public static int REQUEST_BUFFER = 1;
	    public static String defult_file = "/sdcard/daoimg/";
	    private static OkHttpClient okHttpClient = new OkHttpClient();
	    static {
	        isFolderExists(defult_file);
	     }
	    
	   public static void inItOkhttp(Context context) {
		   mContext = context;
	   }
	    
	    static void  isFolderExists(String arg) {
	        File strFolder=new File(arg);
	        if (!strFolder.exists())
	            strFolder.mkdirs();
	    }
	    public static OkHttpGetBulider get() {
	    	
	    	return new OkHttpGetBulider();

	    }
	    public static OkHttpPostBulider post() {
	        return new OkHttpPostBulider();
	    }
	    public static OkHttpClient getOkHttpClient() {
	        return okHttpClient;
	    }
}
