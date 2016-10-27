package com.example.dan.mothertobe.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetUT {
	
private static final String TAG = "NetUT";
	
	public static boolean isConnected(Context context) {
		 ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		 
		 NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		 if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		 return false;
	}	
	
	public static String getLocalIpAddress() {
	    try {
	        for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); 
			en.hasMoreElements();) {
	            NetworkInterface intf = en.nextElement();
	            for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); 
			enumIpAddr.hasMoreElements();) {
	                InetAddress inetAddress = enumIpAddr.nextElement();
	                if (!inetAddress.isLoopbackAddress()) {
	                    return inetAddress.getHostAddress().toString();
	                }
	            }
	        }
	    } catch (SocketException ex) {
//	    	LogHelper.bLog().e(ex);
//	    	
//	    	Log.i("NetUT", ex);
	    }
	    return null;
	}

}
