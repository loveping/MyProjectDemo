package com.example.dan.mothertobe.Network;

import android.content.Context;

public interface PosunOkHttp3CallBack {
	public void OnSuccess(GsonRespone respone, String Methomd);
    public void Onfailed(Exception e, String Methomd);
    public Context  getAcitiveContext();
}
