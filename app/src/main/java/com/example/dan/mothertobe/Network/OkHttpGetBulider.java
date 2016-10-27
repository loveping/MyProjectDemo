package com.example.dan.mothertobe.network;

import android.net.Uri;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OkHttpGetBulider {
	
	private Map<String, String> params = new HashMap<>();
    private String url="";
    
    public OkHttpGetBulider addParams(String key, String value) {
        params.put(key, value);
        return this;
    }

    public OkHttpGetRequest build() {
        return new OkHttpGetRequest(appendParams(url,params)).Builder();
    }
    public OkHttpGetBulider url(String url){
        this.url=url;
        return this;
    }
    private String appendParams(String url, Map<String, String> params) {
        if (url == null || params == null || params.isEmpty()) {
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        Set<String> keys = params.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            builder.appendQueryParameter(key, params.get(key));
        }
        return builder.build().toString();
    }

}
