package com.example.dan.mothertobe.network;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class OkHttpPostBulider {
	
	private String url="";
    List<File> list = new ArrayList<>();
    private static MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");
    public static final MediaType FILE_TYPE =  MediaType.parse("application/octet-stream");
    private MediaType mediaType;
    private RequestBody mRequestBody;
    public OkHttpPostBulider addFileParams(File file) {
        list.add(file);
        return this;
    }
    public OkHttpPostBulider upload(){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("param","value");
        for (File file : list) {
            RequestBody fileBody = RequestBody.create(FILE_TYPE, file);
            builder.addFormDataPart("files", file.getName(), fileBody);
        }
        mRequestBody=builder.build();
        return this;
    }
    public OkHttpPostBulider mediaType(MediaType mediaType){
         this.mediaType=mediaType;
         return this;
    }
    public OkHttpPostBulider body(Object object){
         mRequestBody=RequestBody.create(mediaType==null?MEDIA_TYPE_PLAIN:mediaType, GsonPrase.getGson().toJson(object));
         return this;
    }
    public OkHttpPostRequest build() {
        return new OkHttpPostRequest(url,mRequestBody).builde();
    }
    public OkHttpPostBulider url(String url){
        this.url=url;
        return this;
    }

}
