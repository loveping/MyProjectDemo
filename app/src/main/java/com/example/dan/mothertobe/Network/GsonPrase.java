package com.example.dan.mothertobe.Network;

import com.google.gson.Gson;

public class GsonPrase {

	private static Gson mgson;
    public static Gson getGson(){
        if(mgson==null){
            mgson=new Gson();
        }
        return mgson;
    }
}
