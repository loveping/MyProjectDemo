package com.example.dan.mothertobe.network;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class CheckNet{
	
	public static boolean checkNet(final Context mContext) {
		try {
			if (!NetUT.isConnected(mContext)) {
				ActivityManager am = (ActivityManager) mContext.getSystemService(Activity.ACTIVITY_SERVICE);
				ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
				new AlertDialog.Builder(mContext).setTitle("连接失败")
						.setMessage("网络连接失败")
						.setPositiveButton("设置", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,int which) {

								//mContext.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
								Intent wifiSettingsIntent = new Intent("android.settings.WIFI_SETTINGS");   
								mContext.startActivity(wifiSettingsIntent);
								
							}
						}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog,int which) {
						///**
					}
				}).show();
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
