package com.ase.mymoney.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;

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
	
	public static float getEurMultiplier() throws ClientProtocolException, IOException, IllegalStateException, XmlPullParserException{
		String url = "http://www.bnro.ro/nbrfxrates.xml";
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		
		HttpResponse resp = httpClient.execute(httpGet);
		
		if(resp.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
			HttpEntity entityResp = resp.getEntity();
						
			XmlPullParser parser = Xml.newPullParser();
			parser.setInput(entityResp.getContent(), null);
			
			int eventType = parser.getEventType();

	        while (eventType != XmlPullParser.END_DOCUMENT){
	            if(eventType==XmlPullParser.START_TAG){
	            	String name =parser.getName();
	            	if(name.equalsIgnoreCase("rate")){
	            		String atr=parser.getAttributeValue(0);
	            		if(atr.equalsIgnoreCase("EUR")){
	            			String value = parser.nextText();
	            			return Float.parseFloat(value);
	            		}
	            	}
	            }
	            parser.next();
	            eventType = parser.getEventType();
	        }

		}
		return getCurrency(); //on fail, return last known value
	}
	
	public static void saveCurrency(float currency){
		SharedPreferences sp = mContext.getSharedPreferences(
				"MyMoneyProfil", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putFloat("CURRENCY", currency);
		editor.commit();
	}
	
	public static float getCurrency(){
		SharedPreferences sp = mContext.getSharedPreferences("MyMoneyProfil", Context.MODE_PRIVATE);
		return sp.getFloat("CURRENCY", 0);
	}
	
}
