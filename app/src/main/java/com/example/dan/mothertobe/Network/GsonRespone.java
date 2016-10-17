package com.example.dan.mothertobe.Network;

import java.util.Arrays;
import java.util.List;


public class GsonRespone {
	
	  String result;
	    public <T> T toEntity(Class<T> arg){
	       return GsonPrase.getGson().fromJson(result,arg);
	    }
	    public GsonRespone setResult(String arg){
	        this.result=arg;
	        return this;
	    }
	    public <T> List<T> toListEntity(Class<T[]> type){
	        T[] list= GsonPrase.getGson().fromJson(result,type);
	        return  Arrays.asList(list);
	    }
	    public <T> List<T> toListEntitybyIndex(Object key,Class<T[]> type) throws Exception{
	        if(key instanceof Integer){
	            T[] list= GsonPrase.getGson().fromJson(new org.json.JSONArray(result).getString((Integer) key),type);
	            return Arrays.asList(list);
	        }else if(key instanceof String){
	            T[] list= GsonPrase.getGson().fromJson(new org.json.JSONObject(result).getString((String) key),type);
	            return Arrays.asList(list);
	        }
	        return null;
	    }
	    public String toString(){
	        return result;
	    }

}
