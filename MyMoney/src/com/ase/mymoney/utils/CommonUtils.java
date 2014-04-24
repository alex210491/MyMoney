package com.ase.mymoney.utils;

import android.content.Context;

public class CommonUtils {
	
	public static int UM_RON = 1;
	public static int UM_EUR = 2;
	
	public static Context mContext;
	
	public static void setApplicationContext(Context context){
		mContext = context;
	}
	
	public static int getUM(String um){
		if(um.equalsIgnoreCase("ron")) return UM_RON;
		if(um.equalsIgnoreCase("eur")) return UM_EUR;
		return -1;
	}
	
}
